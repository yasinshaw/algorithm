package list;

public class MyLinkedList<T> implements IList<T> {

    private int count = 0;
    private Node head = new Node();
    private class Node{
        T data;
        Node next;

        public Node() {
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void insert(int i, T data) {
        if (i < 0 || i > this.count)
            throw new RuntimeException("下标非法");
        Node prev = getNode(i - 1);
        prev.next = new Node(data, prev.next);
        count++;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= count)
            throw new RuntimeException("下标非法");
        return this.getNode(i).data;
    }

    @Override
    public T delete(int i) {
        if (i < 0 || i >= count)
            throw new RuntimeException("下标非法");
        Node prev = getNode(i - 1);
        Node node = prev.next;
        prev.next = node.next;
        count--;
        return node.data;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * 得到第i个位置的元素
     * 注意k的初始条件和while循环递增
     * @param i 若i为-1，返回head
     * @return
     */
    private Node getNode(int i) {
        int k = - 1;
        Node res = head;
        while (k++ < i)
            res = res.next;
        return res;
    }
}
