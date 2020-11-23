package ua.edu.ucu.collections.immutable;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test(expected = NullPointerException.class)
    public void testAddNullPointer() {
        Object[] myIntArray = {1, 2, 3};
        ImmutableArrayList myList = new ImmutableArrayList(myIntArray);
        ImmutableList almostList = myList.add(null);
        Object[] almostListArr = almostList.toArray();
        assertArrayEquals(myIntArray, almostListArr);
    }

    @Test
    public void testAdd() {
        Object[] myObjArr = {0.5, 1, 3.8};
        Object objToAdd = 5.9;
        ImmutableArrayList immArrList = new ImmutableArrayList(myObjArr);
        ImmutableList newArrList = immArrList.add(objToAdd);
        Object[] newArrListArr = newArrList.toArray();
        Object[] resultArr = {0.5, 1, 3.8, 5.9};

        assertNotSame(myObjArr, newArrListArr);
        assertArrayEquals(resultArr ,newArrListArr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexOut() {
        Object[] myObjArr = {1, 2, "3"};
        ImmutableArrayList myImmArrList = new ImmutableArrayList(myObjArr);
        myImmArrList.add(3, 5);
        myImmArrList.add(-1, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testAddWithIndexNullPointer() {
        ImmutableArrayList myImmArrList = new ImmutableArrayList();
        myImmArrList.add(null);
    }

    @Test
    public void testAddWithIndex() {
        Object[] myObjArr = {"2", 0.5, 12};
        ImmutableArrayList myImmArrList = new ImmutableArrayList(myObjArr);
        Object objToAdd = 5;
        ImmutableList myImmListOne = myImmArrList.add(2, objToAdd);
        Object[] expArrOne = {"2", 0.5, 5, 12};
        Object[] actArrOne = myImmListOne.toArray();

        ImmutableList myImmListTwo = myImmListOne.add(2, 3.33);
        Object[] expArrTwo = {"2", 0.5, 3.33, 5, 12};
        Object[] actArrTwo = myImmListTwo.toArray();

        assertArrayEquals(expArrOne, actArrOne);
        assertArrayEquals(expArrTwo, actArrTwo);
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllNullExc() {
        Object[] myArr = {1, 2, 3};
        ImmutableArrayList myImmArrList = new ImmutableArrayList(myArr);
        myImmArrList.addAll(null);
    }

    @Test
    public void testAddAll() {
        Object[] myArr = {1, "2", 3.0};
        Object[] stuffToAdd = {2.0, 5};
        ImmutableArrayList myImmArrListOne = new ImmutableArrayList(myArr);
        ImmutableList newImmList = myImmArrListOne.addAll(stuffToAdd);

        Object[] expStuff = {1, "2", 3.0, 2.0, 5};
        Object[] actStuff = newImmList.toArray();

        assertArrayEquals(expStuff, actStuff);
        assertNotSame(myArr, actStuff);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndexIndexErr() {
        Object[] myObjArr = {1, "2", 3.0};
        Object[] stuffToAdd = {"12,", 24.5};
        ImmutableArrayList myImmArrList = new ImmutableArrayList(myObjArr);
        myImmArrList.addAll(3, stuffToAdd);
        myImmArrList.addAll(-4, stuffToAdd);

        ImmutableArrayList finalArrList = new ImmutableArrayList();
        finalArrList.addAll(1, stuffToAdd);
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllWithIndexNullErr() {
        Object[] myObjArr = {"1", "25gerg", 2};
        ImmutableArrayList myList = new ImmutableArrayList(myObjArr);
        myList.addAll(null);
    }

    @Test
    public void testAddAllWithIndex() {
        Object[] initArr = {2.5, 95, "95"};
        Object[] stuffToAdd = {11, 95.5};
        ImmutableArrayList myListOne = new ImmutableArrayList(initArr);
        ImmutableList newListOne = myListOne.addAll(2, stuffToAdd);

        Object[] expListOne = {2.5, 95, 11, 95.5, "95"};
        Object[] actListOne = newListOne.toArray();

        assertArrayEquals(expListOne, actListOne);

        ImmutableList newListTwo = newListOne.addAll(4, stuffToAdd);
        Object[] expListTwo = {2.5, 95, 11, 95.5, 11, 95.5, "95"};
        Object[] actListTwo = newListTwo.toArray();

        assertArrayEquals(expListTwo, actListTwo);

        ImmutableList newListThree = newListTwo.addAll(0, stuffToAdd);
        Object[] expListThree = {11, 95.5, 2.5, 95, 11, 95.5, 11, 95.5, "95"};
        Object[] actListThree = newListThree.toArray();

        assertArrayEquals(expListThree, actListThree);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithIndexErr() {
        Object[] myObjArr = {1, 2};
        ImmutableArrayList myArrList = new ImmutableArrayList(myObjArr);
        myArrList.get(2);
        myArrList.get(-1);
    }

    @Test
    public void testGet() {
        Object[] initStuff = {1, 2};
        ImmutableArrayList myImmArrList = new ImmutableArrayList(initStuff);
        Object expOne = 1;
        Object actOne = myImmArrList.get(0);
        Object expTwo = 2;
        Object actTwo = myImmArrList.get(1);

       assertEquals(expOne, actOne);
       assertEquals(expTwo, actTwo);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithIndexErr() {
        Object[] myStuff = {1, 2};
        ImmutableArrayList myImmArrList = new ImmutableArrayList(myStuff);
        myImmArrList.get(3);
        myImmArrList.get(-1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetWithNullErr() {
        Object[] myArr = {2, 2};
        ImmutableArrayList myArrList = new ImmutableArrayList(myArr);
        myArrList.set(1, null);
    }

    @Test
    public void testSet() {
        Object[] myInitObjs = {"1", 25, 34};
        ImmutableArrayList myImmArrList = new ImmutableArrayList(myInitObjs);
        ImmutableList newListOne = myImmArrList.set(0, 1);
        Object[] expResOne = {1, 25, 34};
        Object[] actResOne = newListOne.toArray();

        assertArrayEquals(expResOne, actResOne);
    }

    @Test
    public void testSize() {
        ImmutableArrayList emptyList = new ImmutableArrayList();
        int expResOne = 0;
        int actResOne = emptyList.size();
        assertEquals(expResOne, actResOne);

        Object[] myObjs = {1, 2};
        ImmutableArrayList newList = new ImmutableArrayList(myObjs);
        int expResTwo = newList.toArray().length;
        int actResTwo = newList.size();

        assertEquals(expResTwo, actResTwo);

        ImmutableList finalList = newList.addAll(myObjs);
        int finalNotEqSize = finalList.size();

        assertNotEquals(newList.size(), finalNotEqSize);
    }

    @Test
    public void testClearAndEpmty() {
        Object[] myObjs = {1, 2};
        ImmutableArrayList immListOne = new ImmutableArrayList(myObjs);
        ImmutableArrayList immListTwo = new ImmutableArrayList();
        ImmutableList immListThree = immListOne.clear();

        assertFalse(immListOne.isEmpty());
        assertTrue(immListTwo.isEmpty());
        assertNotEquals(immListOne.size(), immListThree.size());
        assertEquals(immListTwo.size(), immListThree.size());
    }

    @Test
    public void testIndexOf() {
        Object[] objects = {1, "2"};
        ImmutableArrayList newListOne = new ImmutableArrayList(objects);
        int expResOne = -1;
        int actResOne = newListOne.indexOf("3");

        assertEquals(expResOne, actResOne);

        int expResTwo = 1;
        int actResTwo = newListOne.indexOf("2");

        assertEquals(expResTwo, actResTwo);

        ImmutableList newListTwo = newListOne.add("2");

        int expResThree = 1;
        int actResThree = newListTwo.indexOf("2");
        assertEquals(expResThree, actResThree);
    }

    @Test
    public void testToString() {
        Object[] myObjects = {1, "1", 15.6};
        ImmutableArrayList myImmArrListOne = new ImmutableArrayList(myObjects);
        String expStringOne = Arrays.toString(myObjects);
        String actStringOne = myImmArrListOne.toString();

        assertEquals(expStringOne, actStringOne);

        ImmutableList myImmArrListTwo = myImmArrListOne.add(190);
        String newString = myImmArrListTwo.toString();

        assertNotEquals(actStringOne, newString);
    }
}
