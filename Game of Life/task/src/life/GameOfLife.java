package life;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;


//View Class
public class GameOfLife extends JFrame {
    private JLabel generationLabel;
    private JLabel aliveLabel;
    private JPanel[][] miniLifePanels;
    private JToggleButton toggleButton;
    private JButton resetButton;
    private int gridRows;
    private int gridColumns;
    private GameController controller;

    private Timer timer = new Timer(0, (event)->{
            populatePanel();

    });



    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        int rows = 20, cols = 20, generations = 20;
        this.controller = new GameController();
        controller.setGame(this);
        controller.initializeGame();
        //controller.startGame();
    }

    public static void main(String[] args) {
        new GameOfLife();
    }

    public void buildPanels() {
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
        buildLabelPanel();
        buildGridPanel();
        setVisible(true);
    }

    private void buildLabelPanel() {
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        generationLabel = new JLabel();
        generationLabel.setName("GenerationLabel");
        generationLabel.setText("Generation #");
        aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");
        aliveLabel.setText("Alive #");
        labelPanel.add(generationLabel);
        labelPanel.add(aliveLabel);

        toggleButton = new JToggleButton("Start");
        toggleButton.setName("PlayToggleButton");
        toggleButton.addItemListener((event)->{
            if(toggleButton.isSelected()) {
                System.out.println("Here!");
                toggleButton.setText("Pause");
                controller.startGame();
                timer.start();
            } else {
                toggleButton.setText("Start");
                timer.stop();
                controller.stopGame();
            }
        });
        labelPanel.add(toggleButton);
        resetButton = new JButton("Reset");
        resetButton.setName("ResetButton");
        resetButton.addActionListener((event)->{
            System.out.println("Clicking reset button");
            controller = new GameController(controller.getMatrix(), this);
            controller.resetGame();
            //controller.initializeGame();
            //controller.startGame();
            //timer.start();
        });
        labelPanel.add(resetButton);
        add(labelPanel, Component.LEFT_ALIGNMENT);
    }

    private void buildGridPanel() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(gridRows, gridColumns,2, 2));
        miniLifePanels = new JPanel[gridRows][gridColumns];
        for(int row = 0; row < gridRows; row++) {
            for(int col = 0; col < gridColumns; col++) {
                JPanel miniLifePanel = new JPanel();
                miniLifePanel.setSize(10,10);
                miniLifePanels[row][col] = miniLifePanel;
                gridPanel.add(miniLifePanel);
            }
        }
        add(gridPanel);
    }


    public void setGridSize(int gridRows, int gridColumns) {
        this.gridRows = gridRows;
        this.gridColumns = gridColumns;
    }

    public void updateGeneration(LifeMatrix matrix) {
        generationLabel.setText("Generation #"+matrix.getGenerationIndex());
    }

    public void activateCell(Cell cell) {
        miniLifePanels[cell.getRow()][cell.getCol()].setBackground(Color.DARK_GRAY);
    }


    public void deactivateCell(Cell cell) {
        miniLifePanels[cell.getRow()][cell.getCol()].setBackground(null);
    }

    public void updateAliveCount(int aliveCount) {
        aliveLabel.setText("Alive #"+aliveCount);
    }

    public void populatePanel() {
        LifeMatrix matrix = controller.getMatrix();
        updateGeneration(matrix);
        updateAliveCount(matrix.getAliveCount());
        for(int row = 0; row < gridRows; row++) {
            for(int col = 0; col < gridColumns; col++) {
                Cell cell = matrix.getCurrentCells()[row][col];
                if(cell.getLife())
                    activateCell(cell);
                else
                    deactivateCell(cell);
            }
        }
    }
}


//Data for each cell
class Cell {
    private int neighbors;
    private boolean life;
    private Random random = new Random();
    private LifeMatrix matrix;
    private int row;
    private int col;

    public Cell(int row, int col) {
        life = random.nextBoolean();
        this.row = row;
        this.col = col;
    }

    public void setLife(LifeMatrix matrix) {
        this.matrix = matrix;
    }

    public void activate() {
        life = true;
    }

    public void deactivate() {
        life = false;
    }

    public int getNeighbors() {
        return neighbors;
    }

    public boolean getLife() {
        return life;
    }

    public void setNeighbors(int neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor() {
        neighbors++;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public LifeMatrix getMatrix() {
        return matrix;
    }

}

class LifeMatrix {
    private int rows;
    private int cols;
    private Cell[][] currentCells;
    private int generationIndex = 1;
    private volatile int aliveCount = 0;
    private LifeMatrix nextGenerationMatrix = null;

    public LifeMatrix() {
        this(20,20);
    }

    public LifeMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        currentCells = new Cell[rows][cols];
        initializeCells();
        //nextGenerationMatrix = new LifeMatrix(rows, cols);
    }

    public LifeMatrix(LifeMatrix prevGeneration) {
        this(prevGeneration.getRows(), prevGeneration.getCols());
        generationIndex = prevGeneration.getGenerationIndex()+1;
    }

    private void initializeCells() {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                currentCells[row][col] = new Cell(row, col);
                currentCells[row][col].setLife(this);
            }
        }
        setAliveCount();
    }

    public Cell[][] getCurrentCells() {
        return currentCells;
    }

    public void setCurrentCells(Cell[][] currentCells) {
        this.currentCells = currentCells;
    }

    public int getAliveCount() {
        return aliveCount;
    }

    public int getGenerationIndex() {
        return generationIndex;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public LifeMatrix prepareForEvolution() {
        nextGenerationMatrix = new LifeMatrix(this);
        return nextGenerationMatrix;
    }

    public void setAliveCount() {
        aliveCount = (int)Arrays.stream(currentCells)
                        .mapToLong(cellArray-> Arrays.stream(cellArray)
                                .filter(cell->cell.getLife()).count())
                        .sum();
    }

}

//Controller class
class GameController {

    private LifeMatrix matrix;
    private LifeMatrix evolvedMatrix;
    private GameOfLife game;
    private final List<Thread> threads = new ArrayList<>();
    private MyGameThread gameThread = new MyGameThread(this);




    public GameController(LifeMatrix matrix, GameOfLife game) {
        this.matrix = new LifeMatrix(matrix.getRows(), matrix.getCols());
        this.game = game;
    }

    public GameController() {
        this.matrix = new LifeMatrix(20,20);
    }

    public void setGame(GameOfLife game) {
        this.game = game;
    }

    private void evaluateNeighbors(Cell oldCell, Cell newCell) {
        int oldNeighbors = oldCell.getNeighbors();
        if((oldCell.getLife() && (oldNeighbors == 2 || oldNeighbors == 3)) || (!oldCell.getLife() && oldCell.getNeighbors() == 3)) {
            activateCell(newCell);
        } else {
            deactivateCell(newCell);
        }
    }

    private void countNeighbors(Cell[][] currentCells, int row, int col, int rows, int cols) {
        Cell c = currentCells[row][col];
        c.setNeighbors(0);

        for(int i = -1; i <= 1; i++ ) {
            for(int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0)    continue;
                if(row+i < 0 || row+i >= rows)  continue;
                if(col+j < 0 || col+j >= cols)  continue;

                if(currentCells[row+i][col+j].getLife())
                    c.addNeighbor();
            }
        }
    }

    public void checkNEvaluate() throws InterruptedException {
        Cell[][] currentCells = matrix.getCurrentCells();
        int rows = matrix.getRows();
        int cols = matrix.getCols();
        final int NUM_OF_THREADS = 8;

        evolvedMatrix = matrix.prepareForEvolution();
        threads.clear();
        Cell[][] futureCells = evolvedMatrix.getCurrentCells();

        for(int tid = 0; + tid < NUM_OF_THREADS; tid++) {
            int thread_row_start = tid*rows/NUM_OF_THREADS;
            int thread_row_end = (tid+1)*rows/NUM_OF_THREADS;
            Thread t = new Thread(()->{
                for(int row = thread_row_start; row < thread_row_end; row++) {
                    for(int col = 0; col < cols; col++) {
                        countNeighbors(currentCells, row, col, rows, cols);
                        evaluateNeighbors(currentCells[row][col], futureCells[row][col]);
                    }
                }
            });
            t.start();
            threads.add(t);
        }
        for(Thread t : threads) {
            t.join();
        }
        updateAliveCount();
    }

    private void activateCell(Cell cell) {
        cell.activate();
        //game.activateCell(cell);
    }

    private void deactivateCell(Cell cell) {
        cell.deactivate();
        //game.deactivateCell(cell);
    }

    public void proceedToNextGeneration() {
        this.matrix = evolvedMatrix;
    }

    private void updateAliveCount() {
        matrix.setAliveCount();
        //game.updateAliveCount(matrix.getAliveCount());
    }

    public void initializeGame() {
        game.setGridSize(matrix.getRows(), matrix.getCols());
        game.buildPanels();
        game.populatePanel();
    }

    public void startLoop() throws InterruptedException{
        checkNEvaluate();
        proceedToNextGeneration();
    }

    public void startGame() {
        System.out.println("Hello 2");
        gameThread.start();
    }

    public void stopThreads() {
        Thread t = new Thread(()-> {
            threads.forEach(thread -> thread.interrupt());
        });
        t.start();
    }

    public void stopGame() {
        gameThread.stop();
    }

    public LifeMatrix getMatrix() {
        return matrix;
    }

    public void resetGame() {
        Thread t = new Thread(()->game.populatePanel());
        t.start();
    }
}
class MyGameThread implements Runnable {
    private AtomicBoolean running = new AtomicBoolean(false);
    private Thread worker;
    private GameController controller;

    public MyGameThread(GameController controller) {
        this.controller = controller;
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
        controller.stopThreads();
    }

    public void run() {
        running.set(true);
        while(running.get()) {
            try {
                controller.startLoop();
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }


}