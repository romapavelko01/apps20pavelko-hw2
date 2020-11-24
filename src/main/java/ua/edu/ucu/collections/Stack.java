package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList myList;

    public Stack() {
        myList = new ImmutableLinkedList();
    }

    public Object peek() {
        return myList.getFirst();
    }

    public Object pop() {
        Object resultObj = myList.getFirst();
        myList = myList.removeFirst();
        return resultObj;
    }

    public void push(Object e) {
        myList = myList.addFirst(e);
    }
}
