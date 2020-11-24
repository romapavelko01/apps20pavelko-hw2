package ua.edu.ucu.collections.immutable;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test(expected = NullPointerException.class)
    public void testAddErr() {
        Object[] myList = {1, 2};
        ImmutableLinkedList myImmLinkedList = new ImmutableLinkedList(myList);
        myImmLinkedList.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddWithIndexNullErr() {
        Object[] myList = {1, 2};
        ImmutableLinkedList myImmLinkedList = new ImmutableLinkedList(myList);
        myImmLinkedList.add(1, null);
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
        ImmutableList myNewList = newList.addAll(expArr);

        assertFalse(myNewList.isEmpty());

        assertArrayEquals(expArr, myNewList.toArray());
        assertEquals(6, myNewList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllAndGetWithIndexErr() {
        Object[] myObjs = {1, 2, 3};
        Object[] stuffToAdd = {1, 2};
        ImmutableLinkedList myList = new ImmutableLinkedList(myObjs);
        myList.addAll(3, stuffToAdd);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithIndexErr() {
        Object[] myObjs = {1, 2, 3};
        ImmutableLinkedList myList = new ImmutableLinkedList(myObjs);
        myList.get(3);
        myList.get(-1);
    }

    @Test
    public void testAddAllWithIndex() {
        Object[] myObjs = {1, 2, 3, 4};
        Object[] stuffToAdd = {3.5, "3.5"};
        ImmutableLinkedList myListOne = new ImmutableLinkedList(myObjs);
        ImmutableList myListTwo = myListOne.addAll(3, stuffToAdd);

        Object[] expArrOne = {1, 2, 3, 3.5, "3.5", 4};
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
    public void testSetNullErr() {
        Object[] myArr = {1, 2};
        ImmutableLinkedList myLinked = new ImmutableLinkedList(myArr);
        myLinked.set(1, null);
    }

    @Test(expected = NullPointerException.class)
    public void testIndexOfWithNullErr() {
        Object[] myArr = {1, 2};
        ImmutableLinkedList myLinked = new ImmutableLinkedList(myArr);
        myLinked.indexOf(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithErr() {
        Object[] myArr = {1, 2, 3};
        ImmutableLinkedList myList = new ImmutableLinkedList(myArr);
        myList.remove(3);
    }

    @Test
    public void testRemove() {
        Object[] finalInput = {"1", 2, 3.0};
        ImmutableLinkedList myListOne = new ImmutableLinkedList(finalInput);
        ImmutableList myListTwo = myListOne.remove(0);

        Object[] expArrOne = {2, 3.0};
        Object[] actArrOne = myListTwo.toArray();
        String expArrOneStr = Arrays.toString(expArrOne);
        String actArrOneStr = myListTwo.toString();

        ImmutableList myListThree = myListTwo.remove(1);
        Object[] expArrTwo = {2};
        Object[] actArrTwo = myListThree.toArray();
        String expArrTwoStr = Arrays.toString(expArrTwo);
        String actArrTwoStr = myListThree.toString();

        ImmutableList myListFour = myListThree.remove(0);
        Object[] expArrThree = {};
        Object[] actArrThree = myListFour.toArray();
        String expArrThreeStr = Arrays.toString(expArrThree);
        String actArrThreeStr = myListFour.toString();

        Object[] myList = {1, 2, 3, 4, 5};
        ImmutableLinkedList myListFive = new ImmutableLinkedList(myList);
        ImmutableList myFFF = myListFive.remove(2);

        Object[] expList = {1, 2, 4, 5};
        Object[] actList = myFFF.toArray();
        String expListStr = Arrays.toString(expList);
        String actListStr = myFFF.toString();

        assertArrayEquals(expList, actList);
        assertArrayEquals(expArrOne, actArrOne);
        assertArrayEquals(expArrTwo, actArrTwo);
        assertArrayEquals(expArrThree, actArrThree);

        assertEquals(expArrOneStr, actArrOneStr);
        assertEquals(expArrTwoStr, actArrTwoStr);
        assertEquals(expArrThreeStr, actArrThreeStr);
        assertEquals(expListStr, actListStr);
    }

    @Test(expected = NullPointerException.class)
    public void testSetAndIndexOfErr() {
        Object[] myArr = {1, 2, 3};
        ImmutableLinkedList myList = new ImmutableLinkedList(myArr);
        myList.set(2, null);
        myList.indexOf(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexErr() {
        Object[] myArr = {1, 2, 3};
        ImmutableLinkedList myList = new ImmutableLinkedList(myArr);
        myList.set(-1, 3);
        myList.set(3, 3);
        myList.get(-1);
        myList.get(4);
    }

    @Test
    public void testSetAndGet() {
        Object[] myArr = {"1", 2, 3.0, "4.05"};
        ImmutableLinkedList newList = new ImmutableLinkedList(myArr);
        ImmutableList myList = newList.set(0, 1);
        Object[] expArrOne = {1, 2, 3.0, "4.05"};
        Object[] actArrOne = myList.toArray();
        Object expObjectTwo = expArrOne[0];
        Object actObjectTwo = myList.get(0);
        ImmutableList myListOne = myList.set(3, 4.05);
        Object[] expArrTwo = {1, 2, 3.0, 4.05};
        Object[] actArrTwo = myListOne.toArray();
        Object expObjectOne = expArrTwo[2];
        Object actObjectOne = myListOne.get(2);

        assertEquals(expObjectOne, actObjectOne);
        assertEquals(expObjectTwo, actObjectTwo);
        assertArrayEquals(expArrOne, actArrOne);
        assertArrayEquals(expArrTwo, actArrTwo);
    }

    @Test
    public void testIndexOf() {
        Object[] myArr = {1, "2", 3.0, 4, 4, 18};
        ImmutableLinkedList myList = new ImmutableLinkedList(myArr);

        Object[] newArr = {};
        ImmutableLinkedList anList = new ImmutableLinkedList(newArr);
        int expIndex = -1;
        int actIndex = anList.indexOf("2");
        int expIndexOne = 0;
        int actIndexOne = myList.indexOf(1);
        int expIndexTwo = 3;
        int actIndexTwo = myList.indexOf(4);
        int expIndexThree = 5;
        int actIndexThree = myList.indexOf(18);
        int expIndexFour = -1;
        int actIndexFour = myList.indexOf("18");

        assertEquals(expIndex, actIndex);
        assertEquals(expIndexOne, actIndexOne);
        assertEquals(expIndexTwo, actIndexTwo);
        assertEquals(expIndexThree, actIndexThree);
        assertEquals(expIndexFour, actIndexFour);
    }
}
