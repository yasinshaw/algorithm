package stack;

public class MyLinkedStack<T> implements IStack<T> {

    private class Node {
        T data;
        Node next;
        Node() {}
        Node(T data) {
            this.data = data;
        }
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top = new Node(); // 栈顶为top.next
    private int count = 0;

    @Override
    public void push(T data) {
        Node node = new Node(data, top.next);
        top.next = node;
        count++;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("栈为空");
        return top.next.data;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("栈为空");
        T res = top.next.data;
        top = top.next;
        count--;
        return res;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
