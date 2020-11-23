package ua.edu.ucu.collections.immutable;

public class Node {
    private Node next = null;
    private Object data = null;

    public Node(Object newData) {
        this.data = newData;
    }

    public Node() {

    }

    public void setNext(Node someNode) {
        this.next = someNode;
    }

    public Node getNext() {
        return this.next;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object someData) {
        this.data = someData;
    }
}
