package com.amigood.util;

import java.util.Collection;
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
        this.maxSize = maxSize;
        this.queue = new PriorityQueue<E>(maxSize + 1);
    }

    public int maxSize() {
        return this.maxSize;
    }

    public int getSize() {
        return queue.size();
    }

    public E push(E in) {
        E out = null;

        queue.add(in);
        if (queue.size() > maxSize) {
            out = queue.remove();
        }

        return out;
    }

    public Object[] toArray() {
        return queue.toArray();
    }

}
