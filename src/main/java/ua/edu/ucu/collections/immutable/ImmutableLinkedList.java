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
    public ImmutableLinkedList add(Object e) {
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
    public ImmutableLinkedList add(int index, Object e) {
        if (index >= this.size && this.size != 0 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (e == null) {
            throw new NullPointerException();
        }
        if (this.head == null) {
            return new ImmutableLinkedList(new Node(e), 1);
        }
        else {
            if (index == 0) {
                Node newHead = new Node(e);
                newHead.setNext(this.head);
                return new ImmutableLinkedList(newHead,
                        this.size + 1);
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
                return new ImmutableLinkedList(newHead,
                        this.size + 1);
            }
        }
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
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
            return new ImmutableLinkedList(newHead,
                    this.size + c.length);
        }
        else {
            return new ImmutableLinkedList(c);
        }
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
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
        return new ImmutableLinkedList(newHead,
                this.size + c.length);

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
    public ImmutableLinkedList remove(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.head.getNext() == null) {
            return new ImmutableLinkedList();
        }
        else {
            if (index == 0) {
                Node probe = this.head.getNext();
                return new ImmutableLinkedList(probe,
                        this.size - 1);
            }
            else {
                Node probe = this.head;
                Node newHead = probe;
                for (int myIndex = 0; probe != null
                        && myIndex < index - 1; myIndex++) {
                    probe = probe.getNext();
                }
                Node newNode = probe.getNext().getNext();
                probe.setNext(newNode);
                return new ImmutableLinkedList(newHead,
                        this.size - 1);
            }
        }
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
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

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(this.size() - 1);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(this.size() - 1);
    }

    @Override
    public ImmutableLinkedList clear() {
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
        while (index < this.size) {
            myArr[index] = probe.getData();
            probe = probe.getNext();
            index += 1;
        }
        return myArr;
    }

    @Override
    public String toString() {
        StringBuilder resStr = new StringBuilder();
        resStr.append("[");
        Node probe = this.head;
        for (int j = 0; j < this.size; j++) {
            resStr.append(probe.getData());
            if (j != this.size - 1) {
                resStr.append(", ");
            }
            probe = probe.getNext();
        }
        resStr.append("]");
        return resStr.toString();
    }
}
