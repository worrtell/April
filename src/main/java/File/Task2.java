package File;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("task2.log")))) {
            int s;
            int[] array = new int[10000000];
            while ((s = reader.read()) != -1) {
                array[s] += 1;
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0) {
                    System.out.println((char) i + "\t" + array[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
