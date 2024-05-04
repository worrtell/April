package Addreses;
import java.io.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/Dell/Downloads/data-1712124662054.csv")))) {
            ArrayList<Addres> array = new ArrayList<>();
            int t;
            String id = "";
            String fullpath = "";
            int cnt = 0;
            boolean flag = true;
            while ((t = reader.read()) != -1) {
                char s = (char) t;
                if (s == ',') {
                    flag = false;
                }
                else {
                    if (flag) {
                        id += s;
                    }
                    else {
                        if (s == '"') {
                            cnt ++;
                        }
                        else {
                            switch (cnt) {
                                case 1:
                                    fullpath += s;
                                    break;
                                case 2:
                                    array.add(new Addres(id,fullpath));
                                    id = "";
                                    fullpath = "";
                                    cnt = 0;
                                    flag = true;
                                    break;
                            }
                        }
                    }
                }
            }
            System.out.println(array.get(100).toString());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
