import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplesTest {

    Apples apple;

    @Before
    public void setUp() {
        apple = new Apples();
    }

    @Test
    public void getApple_pass() {
        String expected = "apple";
        String actual = apple.getApple();
        assertEquals(expected, actual);
    }
}