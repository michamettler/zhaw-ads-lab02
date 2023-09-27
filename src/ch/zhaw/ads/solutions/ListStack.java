package ch.zhaw.ads.solutions;

import ch.zhaw.ads.Stack;

public class ListStack implements Stack {

    int capacity = 1000;
    int top = -1;
    Object[] stack = new Object[capacity];

    @Override
    public void push(Object x) throws StackOverflowError {
        if (!isFull()) {
            top++;
            stack[top] = x;
        } else {
            throw new StackOverflowError();
        }
    }

    @Override
    public Object pop() {
        if (!isEmpty()) {
            Object popObj = stack[top];
            stack[top--] = null;
            return popObj;
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public Object peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            return null;
        }
    }

    @Override
    public void removeAll() {
        for (int i = 0; i < top + 1; i++) {
            stack[i] = null;
        }
    }

    @Override
    public boolean isFull() {
        return top + 1 == capacity;
    }
}
