package ch.zhaw.ads;

import ch.zhaw.ads.solutions.BracketServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ADS1_3_test {
    BracketServer bs;

    @BeforeEach
    public void setUp() {
        bs = new BracketServer();
    }

    private void test(String content, boolean expected) {
        assertEquals(expected, bs.checkBrackets(content), content);
    }

    @Test
    public void testBracket() {
        test("/*/* */", false);
        test("/*", false);
    }
}
