package ua.edu.ucu.collections.immutable;
import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] myArray;

    public ImmutableArrayList() {
        this.myArray = new Object[0];
    }

    public ImmutableArrayList(Object[] anotherArray) {
        this.myArray = anotherArray.clone();
    }


    @Override
    public ImmutableList add(Object e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Object[] newArray = new Object[this.myArray.length + 1];
        for (int i = 0; i < this.myArray.length; i++) {
            newArray[i] = this.myArray[i];
        }
        newArray[newArray.length - 1] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index >= this.myArray.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (e == null) {
            throw new NullPointerException();
        }
        Object[] finalArray = new Object[this.myArray.length + 1];
        int finalIndex = 0;
        int myIndex = 0;
        while (myIndex < index) {
            finalArray[myIndex] = this.myArray[myIndex];
            myIndex += 1;
        }
        finalArray[index] = e;
        while (index < this.myArray.length) {
            finalArray[index + 1] = this.myArray[index];
            index += 1;
        }
        return new ImmutableArrayList(finalArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        if (c == null) {
            throw new NullPointerException();
        }
        Object[] newArray = new Object[c.length + this.myArray.length];
        int myIndex = 0;
        while (myIndex < this.myArray.length) {
            newArray[myIndex] = this.myArray[myIndex];
            myIndex += 1;
        }
        int cIndex = 0;
        while (myIndex < this.myArray.length + c.length && cIndex < c.length) {
            newArray[myIndex] = c[cIndex];
            cIndex += 1;
            myIndex += 1;
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index >= this.myArray.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (c == null) {
            throw new NullPointerException();
        }
        Object[] resultArr = new Object[c.length + this.myArray.length];
        int myIndex = 0;
        int resultIndex = 0;
        while (myIndex < index) {
            resultArr[resultIndex] = this.myArray[myIndex];
            myIndex += 1;
            resultIndex += 1;
        }
        int cIndex = 0;
        while (cIndex < c.length) {
            resultArr[resultIndex] = c[cIndex];
            cIndex += 1;
            resultIndex += 1;
        }
        while (myIndex < this.myArray.length) {
            resultArr[resultIndex] = this.myArray[myIndex];
            myIndex += 1;
            resultIndex += 1;
        }
        return new ImmutableArrayList(resultArr);
    }

    @Override
    public Object get(int index) {
        if (index >= this.myArray.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.myArray[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= this.myArray.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] finalArray = new Object[this.myArray.length - 1];
        int myIndex = 0;
        int finalIndex = 0;
        while (finalIndex < finalArray.length && myIndex < this.myArray.length) {
            if (myIndex == index) {
                myIndex += 1;
            }
            finalArray[finalIndex] = this.myArray[myIndex];
            finalIndex += 1;
            myIndex += 1;
        }
        return new ImmutableArrayList(finalArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= this.myArray.length) {
            throw new IndexOutOfBoundsException();
        }
        if (e == null) {
            throw new NullPointerException();
        }
        Object[] finalArray = this.myArray.clone();
        finalArray[index] = e;
        return new ImmutableArrayList(finalArray);

    }

    @Override
    public int indexOf(Object e) {
        int resIndex = -1;
        int counterI = 0;
        while (counterI < this.myArray.length) {
            if (this.myArray[counterI] == e) {
                resIndex = counterI;
                break;
            }
            counterI += 1;
        }
        return resIndex;
    }

    @Override
    public int size() {
        return this.myArray.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.myArray.length == 0;
    }

    @Override
    public Object[] toArray() {
        return this.myArray.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.myArray);
    }
}
