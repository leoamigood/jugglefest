package com.amigood.puzzle.jugglefest.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/16/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Juggler {

    public Integer hRank;
    public Integer eRank;
    public Integer pRank;

    private LinkedList<Circuit> circuits;

    public Juggler(LinkedList<Circuit> circuits) {
        this.circuits = circuits;
    }

    public Circuit getNextCircuit(){
        return circuits.pop();
    }

}
