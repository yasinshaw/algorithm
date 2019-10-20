package heap;

import java.util.Comparator;

public class MyHeap<T> implements IHeap<T> {
    T[] datas; // 存放数据的数组 datas[1..n]
    private int count = 0; // 计数
    private Comparator<T> comparator; // 比较器

    // 使用空数组构造，容量为capacity
    public MyHeap(int capacity, Comparator<T> comparator) {
        this.datas = (T[]) new Object[capacity + 1];
        this.comparator = comparator;
    }

    // 使用已给的数组构造，容量为数组长度
    public MyHeap(T[] datas, Comparator<T> comparator) {
        this.count = datas.length;
        this.datas = (T[]) new Object[count + 1];
        this.comparator = comparator;
        System.arraycopy(datas, 0, this.datas, 1, count);
        // 对前半部分逆序下沉，构造堆
        for (int k = count / 2; k >= 1; k--)
            sink(k);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void add(T data) {
        if (count == datas.length - 1)
            throw new RuntimeException("堆已满");
        datas[++count] = data;
        swim(count);
    }

    @Override
    public T pop() {
        return remove(1);
    }

    @Override
    public T remove(int i) {
        if (isEmpty()) {
            throw new RuntimeException("堆为空");
        }
        if (i < 1 || i > count) {
            throw new RuntimeException("下标非法");
        }
        T res = datas[i];
        datas[i] = datas[count];
        datas[count--] = null; // 防止对象游离
        sink(i);
        return res;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("堆为空");
        }
        return datas[1];
    }

    /**
     * 比较两个数，看谁上浮
     * @param i 第一个数
     * @param j 第二个数
     * @return true 为i上浮， false 为j上浮
     */
    private boolean needSwim(int i, int j) {
        return comparator.compare(datas[i], datas[j]) < 0;
    }

    /**
     * 交换两个数
     * @param i 第一个数的位置
     * @param j 第二个数的位置
     */
    private void exchange(int i, int j) {
        T temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    /**
     * 上浮
     * @param k 开始上浮的位置
     */
    private void swim(int k) {
        while (k > 1 && needSwim(k, k / 2)) {
            exchange(k, k / 2);
            k /= 2;
        }
    }

    /**
     * 下沉
     * @param k 开始下沉的位置
     */
    private void sink(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            // 判断是否超出范围，再判断j 和 j + 1 那个更需要上浮
            if (j < count && needSwim(j + 1, j))
                j++; // 跟需要上浮的那个换
            if (needSwim(j, k))
                exchange(k, j);
            else break;
            k = j;
        }
    }
}
