import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumTest {

    Sum sum;

    @Before
    public void setUp() {
        sum = new Sum();

    }

    @Test
    public void sum_multipleElements() {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(8);
        numbers.add(4);

        int expected = 17;
        assertEquals(expected, sum.sum(numbers));

    }

    @Test(expected = NullPointerException.class)
    public void sum_NullPointerException() {
        List<Integer> numbers = null;
        assertEquals(0,sum.sum(null));
    }

    @Test
    public void sum_oneElementList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        int expected = 1;
        int actual = sum.sum(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void sum_emptyList() {
        List<Integer> numbers = new ArrayList<>();
        int expected = 0;
        int actual = sum.sum(numbers);
        assertEquals(expected, actual);
    }

}