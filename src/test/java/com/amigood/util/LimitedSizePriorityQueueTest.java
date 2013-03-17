package com.amigood.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    public void testIncorrectMaxSize() {
        queue = new LimitedSizePriorityQueue<Object>(-1);
    }

    @Test
    public void testMaxSizeZero() {
        Object o = new Object();

        queue = new LimitedSizePriorityQueue<Object>(0);
        assertEquals(0, queue.maxSize());
        assertEquals(o, queue.push(o));
    }

    @Test
    public void testPushOutString() {
        queue = new LimitedSizePriorityQueue<String>(2);
        assertEquals(2, queue.maxSize());

        assertNull(queue.push("zzz"));
        assertNull(queue.push("bbb"));
        assertEquals("bbb", queue.push("ccc"));
        assertEquals("aaa", queue.push("aaa"));
    }

    @Test
    public void testPushOutInteger() {
        queue = new LimitedSizePriorityQueue<String>(4);
        assertEquals(4, queue.maxSize());

        assertNull(queue.push(3));
        assertNull(queue.push(-1));
        assertNull(queue.push(4));
        assertNull(queue.push(1));
        assertEquals(-1, queue.push(2));
        assertEquals(1, queue.push(5));
    }

    @Test (expected = NullPointerException.class)
    public void testNull() {
        queue = new LimitedSizePriorityQueue<Object>(3);
        assertEquals(3, queue.maxSize());
        queue.push(null);
    }

    @Test
    public void testPushSame() {
        Date date1 = new Date();

        queue = new LimitedSizePriorityQueue<Date>(3);
        assertEquals(3, queue.maxSize());

        assertNull(queue.push(date1));
        assertNull(queue.push(date1));
        assertNull(queue.push(date1));
        assertEquals(date1, queue.push(new Date()));
    }

    @Test(expected = ClassCastException.class)
    public void testNonComparable() {
        Object o1 = new Object();
        Object o2 = new Object();

        queue = new LimitedSizePriorityQueue<Date>(2);
        queue.push(o1);
        queue.push(o2);
    }
}
