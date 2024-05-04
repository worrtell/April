package Integral;

public class SumTask extends Thread {
    private double a;
    private double b;
    private double sum = 0;

    public double getSum() {
        return sum;
    }

    public SumTask(double a, double b) {
        this.a = a;
        this.b = b;
    }

    private double f(double x) {
        return Math.sin(Math.exp(x));
    }

    public void run() {
        for (double i = a; i < b; i += 0.001) {
            sum += ((f(i) + f(i+0.001))/2)*(0.001);
        }
    }
}
