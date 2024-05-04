package File;

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        Concatenation("C:/Users/Dell/IdeaProjects/Stream/test1.log","C:/Users/Dell/IdeaProjects/Stream/test2.log","fileResult.log");
    }
    public static String Concatenation(String fileName1, String fileName2, String fileNameResult) {
        try {
            FileInputStream[] files = new FileInputStream[]{new FileInputStream(fileName1), new FileInputStream(fileName2)};
            FileOutputStream fileResult = new FileOutputStream(fileNameResult);
            for (int i = 0; i < 2; i++) {
                int s;
                while ((s = files[i].read()) != -1) {
                    fileResult.write(s);
                }
                fileResult.flush();
            }
            files[0].close();
            files[1].close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileNameResult;
    }
}
//javac C:\Users\Dell\IdeaProjects\Stream\src\main\java\File\MainTask1.java
//java C:\Users\Dell\IdeaProjects\Stream\src\main\java\File\MainTask1.java C:\Users\Dell\IdeaProjects\Stream\test1.log C:\Users\Dell\IdeaProjects\Stream\test2.log fileResult.log
