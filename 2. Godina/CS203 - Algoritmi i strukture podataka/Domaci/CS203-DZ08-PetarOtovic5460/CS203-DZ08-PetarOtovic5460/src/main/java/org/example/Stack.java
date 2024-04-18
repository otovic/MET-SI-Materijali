package org.example;

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) return -1;
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return top.data;
    }

    public void transferSameOrder(Stack otherStack) {
        Stack tempStack = new Stack();
        while (!isEmpty()) {
            int data = pop();
            tempStack.push(data);
            otherStack.push(data);
        }

        while (!tempStack.isEmpty()) push(tempStack.pop());
    }

    public void transferReverseOrder(Stack otherStack) {
        Stack tempStack = new Stack();
        while (!isEmpty()) tempStack.push(pop());
        while (!tempStack.isEmpty()) otherStack.push(tempStack.pop());
    }
}
