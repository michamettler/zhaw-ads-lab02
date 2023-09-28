package ch.zhaw.ads.solutions;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.Objects;

public class MySortedList extends MyList2 implements Comparator {

    @Override
    public boolean add(Object o) {
        Node newNode = new Node(o);

        Node prevNode = head;
        Node currentNode = head.next;
        Node nextNode = currentNode.next;

        for (int i = 0; i < size; i++) {
            if (compare(o, get(i)) <= 0) {
                currentNode.prev = newNode;
                prevNode.next = newNode;
                nextNode.prev = newNode;

                newNode.prev = prevNode;
                newNode.next = currentNode;
                size++;
                return true;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
                nextNode = currentNode.next;
            }
        }

        Node tail = head.prev;

        newNode.prev = tail;
        tail.next = newNode;

        newNode.next = head;
        head.prev = newNode;

        size++;
        return true;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}

class MyList2 extends AbstractList {

    Node head;
    int size = 0;

    public MyList2() {
        head = new Node(null);
        head.next = head;
        head.prev = head;
    }

    public boolean add(Object o) {
        Node newNode = new Node(o);
        Node tail = head.prev;

        newNode.prev = tail;
        tail.next = newNode;

        newNode.next = head;
        head.prev = newNode;

        size++;
        return true;
    }

    public boolean remove(Object obj) {
        Node node = head.next;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(obj, node.data)) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Object get(int pos) {
        Node node = head.next;
        for (int i = 0; i < size; i++) {
            if (i == pos) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = new Node(null);
        head.next = head;
        head.prev = head;
        size = 0;
    }
}

class Node2 {
    Object data;
    Node prev;
    Node next;

    public Node2(Object data) {
        this.data = data;
    }
}
