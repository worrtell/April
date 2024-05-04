package FileApp;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        boolean on = true;
        String dirName = "";
        String fileName;
        File dir = new File(dirName);
        File file;
        while (on) {
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter directory:");
                    dirName = s.next();
                    dir = new File(dirName);
                    if (dir.exists()){
                        System.out.println("you are in directory " + dirName);
                    }
                    else {
                        System.out.println("no such directory");
                    }
                    break;
                case 2:
                    System.out.println("enter new directory:");
                    dirName = s.next();
                    dir = new File(dirName);
                    dir.mkdir();
                    System.out.println("directory " + dirName + " is created");
                    break;
                case 3:
                    System.out.println("enter file name:");
                    fileName = s.next();
                    String newFileName = fileName + "(1)";
                    Files.copy(Path.of(fileName),Path.of(newFileName),REPLACE_EXISTING);
                    System.out.println("copied");
                    break;
                case 4:
                    System.out.println("enter old file name:");
                    file = new File(s.next());
                    System.out.println("enter new file name:");
                    File newFile = new File(s.next());
                    file.renameTo(newFile);
                    System.out.println("renamed");
                    break;
                case 5:
                    System.out.println("files:");
                    for ( File f : dir.listFiles() ){
                        if ( f.isFile() )
                            System.out.println(f);
                    }
                    break;
                case 0:
                    System.out.println("off");
                    on = false;
                    break;
            }
        }
    }
}
