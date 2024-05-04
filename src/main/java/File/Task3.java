package File;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("task3.log")))) {
            String m = "what a day";
            os.writeInt(m.getBytes().length);
            for (int i = 0; i < m.length(); i++) {
                os.writeByte(m.charAt(i));
            }
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
