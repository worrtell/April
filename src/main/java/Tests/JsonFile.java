package Tests;

import java.io.*;
import java.util.*;

public class JsonFile {
    public static void main(String[] args) throws FileNotFoundException, NullPointerException, NotTextFileException {
        try {
            String name = "C:/Users/Dell/IdeaProjects/Stream/src/main/java/Tests/file.txt";
            System.out.println(fileIsCorrect(name));

            try {
                fileIsText(name);
            } catch (NotTextFileException e) {
                System.out.println(e.getMessage());
            }
        }
        catch (NullPointerException e) {
            System.out.println("Unexpected file name!");
        } catch (FileNotFoundException p) {
            System.out.println("No such file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int fileIsCorrect(String name) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(name));
        Stack<String> stack = new Stack<>();
        int cnt = 1;
        while (sc.hasNext()) {
            String p = sc.next();
            for (int i = 0; i < p.length(); i++) {
                String t = Character.toString(p.charAt(i));
                if (t.equals("{") || t.equals("[")) {
                    stack.add(t);
                }
                if (t.equals("}") || t.equals("]")) {
                    if (stack.isEmpty()) {
                        return cnt;
                    }
                    else {
                        String s = stack.pop();
                        if (t.equals("}") & !s.equals("{")) {
                            return cnt;
                        }
                        if (t.equals("]") & !s.equals("[")) {
                            return cnt;
                        }
                    }
                }
                cnt ++;
            }
        }
        if (!stack.isEmpty()) {
            return cnt;
        }
        return 0;
    }

    public static boolean fileIsText(String name) throws NotTextFileException, IOException {
        boolean flag = true;
        boolean ans = true;

        FileInputStream inputStream = new FileInputStream(name);
        int size = inputStream.available();
        if (size > 1024) size = 1024;
        byte[] data = new byte[size];
        inputStream.read(data);

        int ascii = 0;
        int other = 0;

        for (int i = 0; i < data.length; i++) {
            byte t = data[i];
            if (t < 0x09 ) {
                ans = flag = false;
            } // NUL и т.д.
            if (t == 0x09 || t == 0x0A || t == 0x0C || t == 0x0D ) ascii++; // \t, \n и т.д.
            else if (t >= 0x20  &&  t <= 0x7E ) ascii++;
            else other++;
        }

        if ( other != 0 & flag) {
            ans = false;
            flag = false;
        }

        if (flag) {
            ans = !(100 * other / (ascii + other) > 95);
        }
        if (!ans) {
            throw new NotTextFileException();
        }
        return ans;
    }
}
