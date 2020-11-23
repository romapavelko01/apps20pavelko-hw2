package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {

    private final Node head;
    private final int size;

    public ImmutableLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public ImmutableLinkedList(Object[] inputValues) {
        this.size = inputValues.length;
        if (this.size < 1) {
            head = null;
        }
        else {
            Node startingNode = new Node();
            Node current = startingNode;
            for (Object value: inputValues) {
                current.setNext(new Node(value));
                current = current.getNext();
            }
            this.head = startingNode.getNext();
        }
    }

    private ImmutableLinkedList(Node headNode, int linkedSize) {
        this.head = headNode;
        this.size = linkedSize;
    }

    @Override
    public ImmutableList add(Object e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (this.head == null) {
            return new ImmutableLinkedList(new Node(e), 1);
        }
        else {
            Node probe = this.head;
            Node newHead = probe;
            while (probe.getNext() != null) {
                probe = probe.getNext();
            }
            probe.setNext(new Node(e));
            int newSize = this.size + 1;
            return new ImmutableLinkedList(newHead, newSize);
        }
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (e == null) {
            throw new NullPointerException();
        }
        if (this.head == null) {
            return new ImmutableLinkedList(new Node(e), 1);
        }
        else {
            Node probe = this.head;
            Node newHead = probe;
            int myIndex = index;
            while (myIndex > 1 && probe.getNext() != null) {
                probe = probe.getNext();
                myIndex -= 1;
            }
            Node newNode = new Node(e);
            newNode.setNext(probe.getNext());
            probe.setNext(newNode);
            return new ImmutableLinkedList(newHead, this.size + 1);
        }
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        if (this.head != null) {
            Node probe = this.head;
            Node newHead = probe;
            while (probe.getNext() != null) {
                probe = probe.getNext();
            }
            if (c.length > 0) {
                Node newNode = new Node(c[0]);
                probe.setNext(newNode);
                for (int j = 1; j < c.length; j++) {
                    newNode.setNext(new Node(c[j]));
                    newNode = newNode.getNext();
                }
            }
            return new ImmutableLinkedList(newHead, this.size + c.length);
        }
        else {
            return new ImmutableLinkedList(c);
        }
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node probe = this.head;
        Node newHead = probe;
        int myIndex = index;
        while (myIndex > 1 && probe.getNext() != null) {
            probe = probe.getNext();
            myIndex -= 1;
        }
        Node nextNode = probe.getNext();
        for (Object value: c) {
            probe.setNext(new Node(value));
            probe = probe.getNext();
        }
        probe.setNext(nextNode);
        return new ImmutableLinkedList(newHead, this.size + c.length);

    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node probe = this.head;
        int myIndex = 0;
        while (myIndex < index) {
            myIndex += 1;
            probe = probe.getNext();
        }
        return probe.getData();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return new ImmutableLinkedList();
        }
        else {
            Node probe = this.head;
            int myIndex = index;
            while (myIndex > 1 && probe.getNext().getNext() != null) {
                probe = probe.getNext();
                myIndex -= 1;
            }
            Node nodeNextNext = probe.getNext().getNext();
            probe.setNext(nodeNextNext);
            return new ImmutableLinkedList(probe, this.size - 1);
            }
        }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (e == null) {
            throw new NullPointerException();
        }
        Node probe = this.head;
        Node newHead = probe;
        int myIndex = 0;
        while (myIndex < index) {
            probe = probe.getNext();
            myIndex += 1;
        }
        probe.setData(e);
        return new ImmutableLinkedList(newHead, this.size);
    }

    @Override
    public int indexOf(Object e) {
        if (e == null) {
            throw new NullPointerException();
        }
        boolean found = false;
        int myIndex = 0;
        Node probe = this.head;
        while (myIndex < this.size) {
            if (probe.getData() == e) {
                found = true;
                break;
            }
            myIndex += 1;
            probe = probe.getNext();
        }
        if (found) {
            return myIndex;
        }
        else {
            return -1;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] myArr = new Object[this.size];
        Node probe = this.head;
        int index = 0;
        while (probe.getNext() != null) {
            myArr[index] = probe.getData();
            probe = probe.getNext();
            index += 1;
        }
        myArr[index] = probe.getData();
        return myArr;
    }
}
