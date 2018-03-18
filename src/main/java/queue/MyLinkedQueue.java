package queue;

public class MyLinkedQueue<T> implements IQueue<T> {

    private class Node {
        T data;
        Node next;

        Node() {
        }

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top = new Node(); // 队首指针，top.next为队首
    private Node tail = top; // 队尾指针,tail为队尾
    private int count = 0;

    @Override
    public void offer(T data) {
        tail.next = new Node(data);
        tail = tail.next;
        count++;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("队列为空");
        return top.next.data;
    }

    @Override
    public T poll() {
        if (isEmpty())
            throw new RuntimeException("队列为空");
        T res = top.next.data;
        top = top.next;
        count--;
        return res;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
