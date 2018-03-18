package queue;

/**
 * 数组实现的循环队列
 */
public class MyArrayQueue<T> implements IQueue<T> {

    private T[] datas; // 存放数据的数组
    private int capacity; // 数组容量
    private int count = 0; // 计数，用于计算长度
    private int top = 0; // 队首位置
    private int tail = -1; // 队尾的上一个位置

    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        this.datas = (T[]) new Object[capacity];
    }

    @Override
    public void offer(T data) {
        if (count == capacity)
            throw new RuntimeException("队列已满");
        tail = (tail + 1) % capacity;
        datas[tail] = data;
        count++;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("队列为空");
        return datas[top];
    }

    @Override
    public T poll() {
        if (isEmpty())
            throw new RuntimeException("队列为空");
        T res = datas[top];
        top = (top + 1) % capacity;
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
