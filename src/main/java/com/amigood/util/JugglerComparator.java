package com.amigood.util;

import com.amigood.puzzle.jugglefest.domain.Circuit;
import com.amigood.puzzle.jugglefest.domain.Juggler;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/18/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class JugglerComparator implements Comparator<Juggler> {

    private Circuit c;

    public JugglerComparator(Circuit circuit) {
        this.c = circuit;
    }

    public int compare(Juggler j1, Juggler j2) {
        return j1.getRank(c) - j2.getRank(c);
    }

}
