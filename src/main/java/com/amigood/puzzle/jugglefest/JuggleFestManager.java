package com.amigood.puzzle.jugglefest;

import com.amigood.puzzle.jugglefest.domain.Circuit;
import com.amigood.puzzle.jugglefest.domain.Juggler;
import com.amigood.util.JugglerComparator;
import com.amigood.util.LimitedSizePriorityQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/16/13
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class JuggleFestManager {
    private static Logger log = LoggerFactory.getLogger(JuggleFestManager.class);

    public Map<Circuit, LimitedSizePriorityQueue<Juggler>> records = new HashMap<Circuit, LimitedSizePriorityQueue<Juggler>>();

    public Map<Circuit, Juggler[]> process(List<Circuit> circuits, List<Juggler> jugglers) {
        int jugglersPerCircuit = jugglers.size() / circuits.size();
        for (Circuit c: circuits) {
            records.put(c, new LimitedSizePriorityQueue<Juggler>(jugglersPerCircuit, new JugglerComparator(c)));
        }

        for (Juggler j: jugglers) {
            addJuggler(j);
        }

        Map<Circuit, Juggler[]> solution = new HashMap<Circuit, Juggler[]>();
        for (Circuit c: records.keySet()) {
            solution.put(c, records.get(c).toArray());
        }
        return solution;
    }

    //we try to add a juggler to his preferred circuit
    //but if we are unable (due to limited space) we try his next preferred circuit
    private void addJuggler(Juggler juggler) {
        Juggler evicted = null;
        do {
            Circuit circuit = juggler.getNextCircuit();
            if (circuit != null) {
                log.trace("Adding: {} -> {}, rank: {}", juggler, circuit, juggler.getRank(circuit));
                evicted = records.get(circuit).push(juggler);
                juggler = evicted;
                if (evicted != null) log.debug("Evicted: {}", evicted);
            } else {
                log.debug("Permanently evicted: {}", juggler);
                evicted = null;
            }
        } while (evicted != null);
    }

    public static int getWinningNumber(Juggler[] jugglers) {
        int sum = 0;
        for (Juggler j: jugglers) {
            sum += Integer.parseInt(j.name.substring(1));
        }

        return sum;
    }
}
