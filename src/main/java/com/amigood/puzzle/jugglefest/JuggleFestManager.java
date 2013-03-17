package com.amigood.puzzle.jugglefest;

import com.amigood.puzzle.jugglefest.domain.Circuit;
import com.amigood.puzzle.jugglefest.domain.Juggler;
import com.amigood.util.LimitedSizePriorityQueue;

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

    public Map<Circuit, LimitedSizePriorityQueue<Juggler>> records = new HashMap<Circuit, LimitedSizePriorityQueue<Juggler>>();

    public Map<Circuit, Juggler[]> process(List<Circuit> circuits, List<Juggler> jugglers) {
        int jugglersPerCircuit = jugglers.size() / circuits.size();
        for (Circuit c: circuits) {
            records.put(c, new LimitedSizePriorityQueue<Juggler>(jugglersPerCircuit));
        }

        for (Juggler j: jugglers) {
            addJuggler(j);
        }

        Map<Circuit, Juggler[]> optimal = new HashMap<Circuit, Juggler[]>();
        for (Circuit c: records.keySet()) {
            optimal.put(c, (Juggler[]) records.get(c).toArray());
        }
        return optimal;
    }

    private void addJuggler(Juggler juggler) {
        Juggler evicted;
        do {
            Circuit nextCircuit = juggler.getNextCircuit();
            evicted = records.get(nextCircuit).push(juggler);
            juggler = evicted;
        } while (evicted != null);
    }

}
