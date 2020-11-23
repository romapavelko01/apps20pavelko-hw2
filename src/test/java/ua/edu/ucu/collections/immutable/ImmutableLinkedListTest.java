package ua.edu.ucu.collections.immutable;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Assert;
import org.junit.Test;
import sun.security.ec.point.ProjectivePoint;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test(expected = NullPointerException.class)
    public void testAddErr() {
        Object[] myList = {1, 2};
        ImmutableLinkedList myImmLinkedList = new ImmutableLinkedList(myList);
        myImmLinkedList.add(null);
    }
    @Test
    public void testAdd() {
        Object[] myList = {10, "2"};
        ImmutableLinkedList myImmLinkedList = new ImmutableLinkedList(myList);
        ImmutableList myNewList = myImmLinkedList.add(25.5);
        Object[] expArr = {10, "2", 25.5};
        Object[] actArr = myNewList.toArray();
        int expSize = 3;
        int actSize = myNewList.size();

        assertEquals(expSize, actSize);
        assertArrayEquals(expArr, actArr);

        ImmutableLinkedList lastImmList = new ImmutableLinkedList();
        ImmutableList myLastList = lastImmList.add(24);

        assertTrue(lastImmList.isEmpty());
        assertFalse(myLastList.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexErr() {
        Object[] myList = {2.5, 3.9};
        ImmutableLinkedList myLinked = new ImmutableLinkedList(myList);
        myLinked.add(2, 3);
        myLinked.add(-2, 2);

    }

    @Test
    public void testAddAll() {
        Object[] objects = {1, 2, 4};
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList(objects);
        Object[] myArr = newLinkedList.toArray();

        assertArrayEquals(objects, myArr);

        ImmutableList myList = newLinkedList.addAll(objects);
        Object[] newArr = myList.toArray();
        Object[] expArr = {1, 2, 4, 1, 2, 4};
        assertArrayEquals(expArr, newArr);

        ImmutableList newList = myList.clear();
        ImmutableList myNewList = newList.add(expArr);

        assertFalse(myNewList.isEmpty());

//        assertArrayEquals(expArr, myNewList.toArray());
//        assertEquals(6, myNewList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndexErr() {
        Object[] myObjs = {1, 2, 3};
        Object[] stuffToAdd = {1, 2};
        ImmutableLinkedList myList = new ImmutableLinkedList(myObjs);
        myList.addAll(3, stuffToAdd);
    }

    @Test
    public void testAddAllWithIndex() {
        Object[] myObjs = {1, 2, 3, 4};
        Object[] stuffToAdd = {3.5, "3.5"};
        ImmutableLinkedList myListOne = new ImmutableLinkedList(myObjs);
        ImmutableList myListTwo = myListOne.addAll(1, stuffToAdd);

        Object[] expArrOne = {1, 3.5, "3.5", 2, 3, 4};
        Object[] actArrOne = myListTwo.toArray();

        assertArrayEquals(expArrOne, actArrOne);
    }
    @Test
    public void testAddWithIndex() {
        Object[] myArr = {1, 2};
        ImmutableLinkedList myList = new ImmutableLinkedList(myArr);
        ImmutableList finalList = myList.add(1, 3);
        Object[] expArr = {1, 3, 2};
        Object[] actArr = finalList.toArray();

        assertArrayEquals(expArr, actArr);

        ImmutableList newFinalList = finalList.add(2, 2);
        int expSize = 4;
        int actSize = newFinalList.size();

        Object[] expArrLast = {1, 3, 2, 2};
        Object[] actArrLast = newFinalList.toArray();

        assertEquals(expSize, actSize);
        assertArrayEquals(expArrLast, actArrLast);
    }

    @Test(expected = NullPointerException.class)
    public void testOther() {
        Object[] myArr = {1, 2};
        ImmutableLinkedList myLinked = new ImmutableLinkedList(myArr);
        myLinked.indexOf(null);
        myLinked.set(1, null);
        myLinked.add(1, null);
    }
}
