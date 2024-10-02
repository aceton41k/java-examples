public class OverLoad {

    public int multiply(int a, int b) {
        return a*b;
    }

    public int calculate(int a, int b) {
        return a + b;
    }

    public double calculate(double a, double b) {
        return a + b;
    }

    // Этот метод с разным возвращаемым типом не перегрузит предыдущие методы.
//    public String calculate(int a, int b) {
//        return "Result: " + (a + b);
//    }
}
