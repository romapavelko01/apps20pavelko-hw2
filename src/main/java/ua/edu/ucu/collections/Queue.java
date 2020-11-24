package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList myList;

    public Queue() {
        this.myList = new ImmutableLinkedList();
    }

    public Object peek() {
        return myList.getFirst();
    }

    public Object dequeue() {
        Object firstObj = myList.getFirst();
        myList = myList.removeFirst();
        return firstObj;
    }

    public void enqueue(Object e) {
        myList = myList.addLast(e);
    }
}
