package com.amigood.puzzle.jugglefest;

import com.amigood.puzzle.jugglefest.domain.Circuit;
import com.amigood.puzzle.jugglefest.domain.Juggler;
import com.amigood.util.JuggleFestLoader;
import org.apache.commons.lang.ArrayUtils;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/18/13
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class JuggleFestRunner {

    public static void main(String [] args) throws Exception {
        JuggleFestLoader registry = new JuggleFestLoader(new URI(args[0]));

        JuggleFestManager manager = new JuggleFestManager();
        Map.Entry<List<Circuit>, List<Juggler>> kvPair = registry.parse();

        long begin = System.currentTimeMillis();
        Juggler[] jugglers = manager.process(kvPair.getKey(), kvPair.getValue()).get(new Circuit("C1970", 10, 10, 10));
        System.out.println("Solution: " + JuggleFestManager.getWinningNumber(jugglers) + "@yodle.com");
    }
}
