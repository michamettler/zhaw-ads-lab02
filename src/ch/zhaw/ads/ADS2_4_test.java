package ch.zhaw.ads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @(#)ListTest.java
 *
 *
 * @author
 * @version 1.00 2017/8/30
 */
public class ADS2_4_test {
    MySortedList list;

    @BeforeEach
    public void setUp() {
        list = new MySortedList();
    }

    @Test
    public void testAdd() {
        list.clear();
        list.add("A");
        Object o = list.get(0);
        assertEquals("A", o);
    }

    @Test
    public void testAdd2() {
        list.clear();
        list.add("B");
        list.add("A");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testAdd3() {
        list.clear();
        list.add("C");
        list.add("B");
        list.add("A");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void testMixed() {
        List<Character> list2 = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Character c = (char) ('A' + (Math.random()*26));
            int op = (int)(Math.random()*2);
            switch (op) {
                case 0:
                    list.add(c);
                    list2.add(c);
                    break;
                case 1:
                    list.remove(c);
                    list2.remove(c);
                    break;
            }
        }
        Collections.sort(list2);
        assertEquals(list2.size(), list.size());
        for (int i = 0; i < list.size(); i++) {
            char c1 = (char)list.get(i);
            char c2 = (char)list2.get(i);
            assertEquals(c1, c2);
        }
    }
}
