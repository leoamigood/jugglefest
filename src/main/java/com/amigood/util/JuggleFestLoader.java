package com.amigood.util;

import com.amigood.puzzle.jugglefest.domain.Circuit;
import com.amigood.puzzle.jugglefest.domain.Juggler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/18/13
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class JuggleFestLoader {
    private static Logger log = LoggerFactory.getLogger(JuggleFestLoader.class);

    private BufferedReader br;

    public JuggleFestLoader(URI uri) throws IOException {
        this.br = new BufferedReader(new InputStreamReader(uri.toURL().openStream()));
    }

    public Map.Entry<List<Circuit>, List<Juggler>> parse() throws IOException {
        Map<String, Circuit> circuits = new HashMap<String, Circuit>();
        List<Juggler> jugglers = new ArrayList<Juggler>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.trim().split("\\s");
            if (split.length > 0) {
                if (split[0].equals("C")) { //this is circuit
                    //map name -> circuit
                    circuits.put(split[1], new Circuit(split[1], parseRank(split[2]), parseRank(split[3]), parseRank(split[4])));
                } else if (split[0].equals("J")) { //this is juggler
                    //create juggler, lookup circuit and add it to preferred list
                    Juggler juggler = new Juggler(split[1], parseRank(split[2]), parseRank(split[3]), parseRank(split[4]));
                    for (String c: split[5].split(",")) {
                        juggler.getCircuits().add(circuits.get(c));
                    }
                    jugglers.add(juggler);
                } else {
                    log.debug("Skipping line: [" + line + "]");
                }
            }
        }

        return new AbstractMap.SimpleEntry<List<Circuit>, List<Juggler>>(new ArrayList<Circuit>(circuits.values()), jugglers);
    }

    private int parseRank(String s) {
        assert(s.matches("\\w:\\d+"));
        return Integer.parseInt(s.split(":")[1]);
    }
}
