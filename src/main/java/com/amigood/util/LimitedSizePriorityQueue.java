package com.amigood.util;

import com.amigood.puzzle.jugglefest.domain.Juggler;
import org.apache.commons.lang.ArrayUtils;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/16/13
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class LimitedSizePriorityQueue<E> {

    private int maxSize;
    private PriorityQueue<E> queue;

    public LimitedSizePriorityQueue(int maxSize) {
        this(maxSize, null);
    }

    public LimitedSizePriorityQueue(int maxSize, Comparator comparator) {
        this.maxSize = maxSize;
        this.queue = new PriorityQueue<E>(maxSize + 1, comparator);
    }

    public int maxSize() {
        return this.maxSize;
    }

    public int size() {
        return queue.size();
    }

    public E push(E in) {
        E out = null;

        queue.add(in);
        if (queue.size() > maxSize) {
            out = queue.poll();
        }

        return out;
    }

    public Juggler[] toArray() {
        return queue.toArray(new Juggler[queue.size()]);
    }

    @Override //unordered!
    public String toString() {
        return "Q: " + ArrayUtils.toString(queue.toArray());
    }
}
