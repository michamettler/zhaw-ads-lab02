package ch.zhaw.ads.solutions;

import java.util.AbstractList;
import java.util.Objects;

public class MyList extends AbstractList {

    private Node head;
    private int size = 0;

    public MyList() {
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

class Node {
    Object data;
    Node prev;
    Node next;

    public Node(Object data) {
        this.data = data;
    }
}
