package Tests;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void testBubbleSort() {
        int[] input = new int[]{5,2,3,1,4};
        int[] expected = new int[]{1,2,3,4,5};
        BubbleSort.sort(input);
        Assert.assertArrayEquals(expected,input);
    }
}

