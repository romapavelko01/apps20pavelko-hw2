package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    private Queue myQueue;

    @Before
    public void setUp() {
        myQueue = new Queue();
        Object[] myArr = {"1", 2.0, 3, "4 and 5", 6};
        for (Object c: myArr) {
            myQueue.enqueue(c);
        }
    }

    @Test
    public void testPeek() {
        assertEquals("1", myQueue.peek());
    }

    @Test
    public void testDequeue() {
        assertEquals("1", myQueue.dequeue());
        assertEquals(2.0, myQueue.dequeue());
    }

    @Test
    public void testEnqueue() {
        myQueue.enqueue("7?");
        assertNotEquals("7?", myQueue.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueIndexError() {
        for (int j = 0; j < 7; j ++) {
            myQueue.dequeue();
        }
    }
}