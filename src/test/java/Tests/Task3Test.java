package Tests;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Task3Test {

    String name = "C:/Users/Dell/IdeaProjects/Stream/src/main/java/Tests/file.txt";
    @Test(expected = NullPointerException.class)
    public void testNullPointerException() throws FileNotFoundException {
        JsonFile.fileIsCorrect(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundException() throws FileNotFoundException {
        JsonFile.fileIsCorrect("");
    }

    @Test(expected = NotTextFileException.class)
    public void testFileIsText() throws  NotTextFileException, IOException {
        JsonFile.fileIsText("C:/Users/Dell/IdeaProjects/Stream/src/main/java/Tests/null.txt");
    }

    @Test
    public void testFileIsCorrect() {
        long output;
        try {
            output = JsonFile.fileIsCorrect("C:/Users/Dell/IdeaProjects/Stream/src/main/java/Tests/file.txt");
            if (output != 0) {
                output = 1;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(0,output);
    }

}
