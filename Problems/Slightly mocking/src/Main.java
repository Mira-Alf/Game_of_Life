class Calculator {
    private CalculatorEngine engine;

    public Calculator(CalculatorEngine engine) {
       this.engine = engine;
    }

    public String divide(int a, int b) {
        try {
            int divideResult = engine.divide(a, b);
            return String.format("Division of %d by %d = %d", a, b, divideResult);
        } catch(ArithmeticException ae) {
            return "Division by zero is prohibited";
        }
    }
}