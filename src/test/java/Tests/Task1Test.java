package Tests;

import File.Task1;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task1Test {
    @Test
    public void TestConcatenation() {
        String testFileName1 = "C:/Users/Dell/IdeaProjects/Stream/test1.log";
        String testFileName2 = "C:/Users/Dell/IdeaProjects/Stream/test2.log";
        String testFileNameResult = "fileResult.log";
        String result = "fileResult.log";
        Task1.Concatenation(testFileName1, testFileName2, testFileNameResult);
        try {
            byte[] expected = Files.readAllBytes(Paths.get(Task1.Concatenation(testFileName1,testFileName2,result)));
            byte[] actual= Files.readAllBytes(Paths.get(result));
            Assert.assertArrayEquals(expected,actual);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}