package ByteArray;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MainFileWriter {
    public static void main(String[] args) {
        try (Writer fw = new FileWriter("task2.log",true)) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String str = scanner.next() + "\n";
                fw.write(str);
            }
            fw.flush();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
