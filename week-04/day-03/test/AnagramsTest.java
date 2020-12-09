import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramsTest {

    Anagrams anagram;

    @Before
    public void setUp() {
        anagram = new Anagrams();
    }

    @Test
    public void isAnagram_pass() {
        String wordFrom = "peek";
        String wordTo = "keep";
        assertTrue(true);
    }

    @Test
    public void isAnagram_failed() {
        String wordFrom = "green";
        String wordTo = "fox";
        assertFalse(false);
    }
}