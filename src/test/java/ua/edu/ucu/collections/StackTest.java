package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack myStack;

    @Before
    public void setUp() {
        myStack = new Stack();
        Object[] myObjects = {"1", 2.0, 3, "4 and 5", 6};
        for (Object value: myObjects) {
            myStack.push(value);
        }
    }

    @Test
    public void testPopAndPeek() {
        assertEquals(6, myStack.peek());
        assertEquals(6, myStack.pop());
        assertEquals("4 and 5", myStack.peek());
    }

    @Test
    public void testPushAndPeek() {
        assertEquals(6, myStack.peek());
        myStack.push("7?");
        assertEquals("7?", myStack.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopIndexErr() {
        for (int j = 0; j < 10; j++) {
            myStack.pop();
        }
    }
}
