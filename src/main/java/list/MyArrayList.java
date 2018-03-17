package list;


public class MyArrayList<T> implements IList<T> {

    private T[] datas;
    private int count = 0;
    private int capacity;

    public MyArrayList(int capacity) {
        datas = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public void insert(int i, T data) {
        if (count == capacity)
            throw new RuntimeException("列表已满");
        if (i < 0 || i > count)
            throw new RuntimeException("下标非法");
        if (i == count)
            datas[count++] = data;
        else {
            System.arraycopy(datas, i, datas, i + 1, count - i);
            datas[i] = data;
            count++;
        }
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= count)
            throw new RuntimeException("下标非法");
        return datas[i];
    }

    @Override
    public T delete(int i) {
        if (i < 0 || i >= count)
            throw new RuntimeException("下标非法");
        T tmp = datas[i];
        System.arraycopy(datas, i + 1, datas, i, count - i);
        count--;
        return tmp;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
