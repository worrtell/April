package Integral;

import java.util.ArrayList;
import java.util.List;

public class MainUsual {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        SumTask a = new SumTask(0,1);
        a.run();
        System.out.println("на 1 потоке: " + a.getSum());
        long endTime = System.nanoTime();
        System.out.println("время " + (endTime-startTime));

        List<SumTask> integrals = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            integrals.add(new SumTask(i*0.25,(i+1)*0.25));
        }

        startTime = System.nanoTime();
        integrals.forEach(SumTask::start);
        integrals.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        double sum = integrals.stream().mapToDouble(SumTask::getSum).sum();
        endTime = System.nanoTime();

        System.out.println("на 4х потоках: " + sum);
        System.out.println("время: " + (endTime-startTime));
    }
}
