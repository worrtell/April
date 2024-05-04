package Tests;

public class NotTextFileException extends Exception {
    public NotTextFileException() {
        super("file is not text!");
    }
}
