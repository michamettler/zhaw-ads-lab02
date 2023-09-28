package ch.zhaw.ads.solutions;

import java.util.Comparator;

public class MySortedList extends MyList implements Comparator {

    @Override
    public boolean add(Object o) {
        Node newNode = new Node(o);

        Node prevNode = head;
        Node currentNode = head.next;

        for (int i = 0; i < size; i++) {
            if (compare(o, get(i)) <= 0) {
                currentNode.prev = newNode;
                prevNode.next = newNode;

                newNode.prev = prevNode;
                newNode.next = currentNode;
                size++;
                return true;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return super.add(o);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}