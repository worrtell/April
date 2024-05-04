package File;

import java.io.*;

public class Task4 {
    public static void main(String[] args) {
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("task3.log")))) {
            String message = "";
            int s;
            byte[] byteArray = new byte[4];
            for (int i = 0; i < 4; i++) {
                s = reader.read();
                byteArray[i] = (byte) s;
            }
            int length = ((byteArray[0] & 0xFF) << 24) | ((byteArray[1] & 0xFF) << 16) | ((byteArray[2] & 0xFF) << 8) | (byteArray[3] & 0xFF);
            while ((s = reader.read()) != -1) {
                message += (char) s;
            }
            System.out.println(length + " " + message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
