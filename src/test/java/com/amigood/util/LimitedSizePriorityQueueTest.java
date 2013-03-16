package com.amigood.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: lamigud
 * Date: 3/16/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class LimitedSizePriorityQueueTest {

    LimitedSizePriorityQueue queue = null;

    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectSize() {
        queue = new LimitedSizePriorityQueue<Object>(-1);
    }

    @Test
    public void testSizeZero() {
        Object o = new Object();

        queue = new LimitedSizePriorityQueue<Object>(0);
        assertEquals(0, queue.maxSize());
        assertEquals(o, queue.push(o));
    }

    @Test
    public void testPushOut() {
        queue = new LimitedSizePriorityQueue<String>(2);
        assertNull(queue.push("one"));
        assertNull(queue.push("two"));
        assertEquals("one", queue.push("three"));
    }

    @Test (expected = NullPointerException.class)
    public void testNull() {
        queue = new LimitedSizePriorityQueue<Object>(3);
        assertEquals(0, queue.push(null));
    }

}
