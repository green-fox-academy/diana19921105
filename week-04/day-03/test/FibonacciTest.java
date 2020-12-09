import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    Fibonacci fibonacci;

    @Before
    public void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void fibonacci_pass() {
        int n = 7;
        int expected = 13;
        int actual = Fibonacci.fibonacci(n);
        assertEquals(expected, actual);
    }

    @Test
    public void fibonacci_FirstBaseCase() {
        int n = 1;
        int expected = 1;
        int actual = Fibonacci.fibonacci(n);
        assertEquals(expected, actual);
    }

    @Test
    public void fibonacci_SecondBaseCase() {
        int n = 0;
        int expected = 0;
        int actual = Fibonacci.fibonacci(n);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void fibonacci_NullPointerException() {
        Integer n = null;
       assertEquals(0, Fibonacci.fibonacci(n));
    }
}