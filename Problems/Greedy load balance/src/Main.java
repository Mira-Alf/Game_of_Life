import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTasks = Integer.parseInt(scanner.nextLine());
        List<Task> tasks = new ArrayList<>();
        for(int i = 0; i < numTasks; i++) {
            String[] taskInfo = scanner.nextLine().split("\\s+");
            Task task = new Task(Integer.parseInt(taskInfo[0]), Integer.parseInt(taskInfo[1]));
            tasks.add(task);
        }
        addTasks(tasks);

    }

    public static void addTasks(List<Task> tasks) {
        TaskQueue queue1 = new TaskQueue();
        TaskQueue queue2 = new TaskQueue();
        List<TaskQueue> queueList = new ArrayList<>();
        queueList.add(queue1);
        queueList.add(queue2);
        Comparator<TaskQueue> comparator = TaskQueue::loadDifference;
        tasks.forEach(task->{
            TaskQueue queue = queueList.stream().sorted(comparator).findFirst().get();
            queue.addTask(task);
        });
        queueList.forEach(queue->queue.displayItems());
    }
}

class Task {
    private int identifier;
    private int loadIndicator;

    public Task(int identifier, int loadIndicator) {
        this.identifier = identifier;
        this.loadIndicator = loadIndicator;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public int getLoadIndicator() {
        return this.loadIndicator;
    }

    public String toString() {
        return ""+this.identifier;
    }
}

class TaskQueue {
    private Queue<Task> queue = new LinkedList<>();

    public void addTask(Task item) {
        queue.offer(item);
    }

    public void displayItems() {
        while(!queue.isEmpty())
            System.out.print(queue.poll()+" ");
        System.out.println();
    }

    public int getCurrentLoad() {
        return queue.stream().mapToInt(task->task.getLoadIndicator()).sum();
    }

    public int loadDifference(final TaskQueue other) {
        return getCurrentLoad()-other.getCurrentLoad();
    }
}