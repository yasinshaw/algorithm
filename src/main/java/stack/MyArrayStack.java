package stack;

public class MyArrayStack<T> implements IStack<T> {

    private T[] datas;
    int count = 0; // 栈长度,兼栈顶指针
    int capacity; // 数组容量

    public MyArrayStack(int capacity) {
        this.capacity = capacity;
        this.datas = (T[]) new Object[capacity];
    }

    @Override
    public void push(T data) {
        if (count == capacity)
            throw new RuntimeException("栈已满");
        this.datas[count++] = data;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("栈为空");
        return datas[count - 1];
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("栈为空");
        return datas[--count];
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
