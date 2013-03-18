package com.amigood.puzzle.jugglefest;

import com.amigood.puzzle.jugglefest.domain.Circuit;
import com.amigood.puzzle.jugglefest.domain.Juggler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/18/13
 * Time: 9:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class JuggleFestManagerTest {

    JuggleFestManager manager = new JuggleFestManager();

    List<Circuit> circuits;
    List<Juggler> jugglers;

    Circuit c0, c1, c2;
    Juggler j0, j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11;

    @Before
    public void setUp() {
        c0 = new Circuit("C0", 7, 7, 10);
        c1 = new Circuit("C1", 2, 1, 1);
        c2 = new Circuit("C2", 7, 6, 4);

        circuits = Arrays.asList(new Circuit[] {c0, c1, c2});

        j0 = new Juggler("J0", 3, 9, 2);
        j1 = new Juggler("J1", 4, 3, 7);
        j2 = new Juggler("J2", 4, 0, 10);
        j3 = new Juggler("J3", 10, 3, 8);
        j4 = new Juggler("J4", 6, 10, 1);
        j5 = new Juggler("J5", 6, 7, 7);
        j6 = new Juggler("J6", 8, 6, 9);
        j7 = new Juggler("J7", 7, 1, 5);
        j8 = new Juggler("J8", 8, 2, 3);
        j9 = new Juggler("J9", 10, 2, 1);
        j10 = new Juggler("J10", 6, 4, 5);
        j11 = new Juggler("J11", 8, 4, 7);

        j0.setCircuits(Arrays.asList(new Circuit[] {c2, c0, c1}));
        j1.setCircuits(Arrays.asList(new Circuit[] {c0, c2, c1}));
        j2.setCircuits(Arrays.asList(new Circuit[] {c0, c2, c1}));
        j3.setCircuits(Arrays.asList(new Circuit[] {c2, c0, c1}));
        j4.setCircuits(Arrays.asList(new Circuit[] {c0, c2, c1}));
        j5.setCircuits(Arrays.asList(new Circuit[] {c0, c2, c1}));
        j6.setCircuits(Arrays.asList(new Circuit[] {c2, c1, c0}));
        j7.setCircuits(Arrays.asList(new Circuit[] {c2, c1, c0}));
        j8.setCircuits(Arrays.asList(new Circuit[] {c1, c0, c2}));
        j9.setCircuits(Arrays.asList(new Circuit[] {c1, c2, c0}));
        j10.setCircuits(Arrays.asList(new Circuit[] {c0, c2, c1}));
        j11.setCircuits(Arrays.asList(new Circuit[] {c0, c1, c2}));

        jugglers = Arrays.asList(new Juggler[]{j0, j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11});
    }

    @Test
    public void testProcess() throws Exception {
        Map<Circuit, Juggler[]> solution = manager.process(circuits, jugglers);

        //what important is the SUM of juggler numbers, but not their order in a queue
        assertEquals(4, solution.get(c2).length);
        assertEquals(6 + 3 + 10 + 0, JuggleFestManager.getWinningNumber(solution.get(c2)));
        assertEquals(9 + 8 + 7 + 1, JuggleFestManager.getWinningNumber(solution.get(c1)));
        assertEquals(5 + 11 + 2 + 4, JuggleFestManager.getWinningNumber(solution.get(c0)));
    }
}
