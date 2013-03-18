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

    public String name;
    public Integer hRank;
    public Integer eRank;
    public Integer pRank;

    private LinkedList<Circuit> circuits;

    public Juggler(String name, int hRank, int eRank, int pRank) {
        assert name.matches("^J\\d+$");

        this.name = name;
        this.hRank = hRank;
        this.eRank = eRank;
        this.pRank = pRank;
    }

    public int getRank(Circuit c) {
        return this.hRank * c.hRank + this.eRank * c.eRank + this.pRank * c.pRank;
    }

    public List<Circuit> getCircuits() {
        return circuits;
    }

    public void setCircuits(List<Circuit> circuits) {
        this.circuits = new LinkedList<Circuit>(circuits);
    }

    public Circuit getNextCircuit(){
        return circuits.pop();
    }

    @Override
    public String toString() {
        return String.format("J %s H:%d E:%d P:%d", name, hRank, eRank, pRank);
    }

}
