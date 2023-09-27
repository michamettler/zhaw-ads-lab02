package ch.zhaw.ads;

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
        test("()", true);
        test("(()]", false);
        test("((([([])])))", true);
        test("[(])", false);
        test("[(3 +3)* 35 +3]* {3 +2}", true);
        test("[({3 +3)* 35} +3]* {3 +2}", false);
    }
}
