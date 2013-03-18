package com.amigood.puzzle.jugglefest.domain;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/16/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Circuit {

    public String name;
    public Integer hRank;
    public Integer eRank;
    public Integer pRank;

    public Circuit(String name, int hRank, int eRank, int pRank) {
        this.name = name;
        this.hRank = hRank;
        this.eRank = eRank;
        this.pRank = pRank;
    }

    @Override
    public String toString() {
        return String.format("C %s H:%d E:%d P:%d", name, hRank, eRank, pRank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circuit circuit = (Circuit) o;

        if (eRank != null ? !eRank.equals(circuit.eRank) : circuit.eRank != null) return false;
        if (hRank != null ? !hRank.equals(circuit.hRank) : circuit.hRank != null) return false;
        if (pRank != null ? !pRank.equals(circuit.pRank) : circuit.pRank != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hRank != null ? hRank.hashCode() : 0;
        result = 31 * result + (eRank != null ? eRank.hashCode() : 0);
        result = 31 * result + (pRank != null ? pRank.hashCode() : 0);
        return result;
    }
}
