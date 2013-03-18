package com.amigood.util;

import com.amigood.puzzle.jugglefest.domain.Circuit;
import com.amigood.puzzle.jugglefest.domain.Juggler;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/18/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class JugglerComparatorTest {

    Circuit circuit = new Circuit("test", 1, 2, 3);
    JugglerComparator comparator = new JugglerComparator(circuit);

    @Test
    public void testComparator() {
        Juggler j1 = new Juggler("J1", 1, 1, 1);
        Juggler j2 = new Juggler("J2", 2, 1, 0);
        Juggler j3 = new Juggler("J3", 0, 0, 2);

        assertTrue(comparator.compare(j1, j2) > 0);
        assertTrue(comparator.compare(j2, j1) < 0);
        assertTrue(comparator.compare(j1, j1) == 0);
        assertTrue(comparator.compare(j1, j3) == 0);
        assertTrue(comparator.compare(j3, j1) == 0);
        assertTrue(comparator.compare(j2, j3) < 0);
        assertTrue(comparator.compare(j3, j2) > 0);
    }

}
