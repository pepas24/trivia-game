package trivia.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import trivia.Utilities;

public class UtilitiesTest {
    @Test
    public void testRemoveExtension() {
        String result = Utilities.removeExtension("myfile.txt");
        String expected = "myfile";

        assertEquals(expected, result);
    }

    @Test
    public void testCapitalize() {
        String result = Utilities.capitalize("my string");
        String expected = "My string";

        assertEquals(expected, result);
    }
}
