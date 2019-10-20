package heap;

import java.util.Comparator;

public class MyIndexHeap<T> implements IHeap<T> {
    T[] datas; // 存放数据的数组 datas[1..n]
    int[] indexes; // 索引数组
    private int count = 0; // 计数
    private Comparator<T> comparator; // 比较器

    // 使用空数组构造，容量为capacity
    public MyIndexHeap(int capacity, Comparator<T> comparator) {
        this.datas = (T[]) new Object[capacity + 1];
        // 为索引开辟空间
        for (int i = 0; i < capacity + 1; i++) {
            indexes[i] = i;
        }
        this.comparator = comparator;
    }

    // 使用已给的数组构造，容量为数组长度
    public MyIndexHeap(T[] datas, Comparator<T> comparator) {
        this.count = datas.length;
        this.datas = (T[]) new Object[count + 1];
        this.indexes = new int[count + 1];
        for (int i = 0; i < count + 1; i++) {
            indexes[i] = i;
        }
        this.comparator = comparator;
        System.arraycopy(datas, 0, this.datas, 1, count);
        // 对前半部分逆序下沉，构造堆
        for (int k = count / 2; k >= 1; k--) {
            sink(k);
        }
        // 对最后一层，也就是后半部分，不断交换到堆顶，再下沉
        int k = count;
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
        if (count == datas.length - 1) {
            throw new RuntimeException("堆已满");
        }
        datas[indexes[++count]] = data;
        swim(count);
    }

    @Override
    public T pop() {
        return remove(0);
    }

    /**
     * 弹出堆顶元素的索引
     *
     * @return 堆顶元素的索引
     */
    public int popMinIndex() {
        int index = indexes[1];
        datas[index] = null;
        exchange(1, count);
        count--;
        sink(1);
        return index - 1;
    }

    @Override
    public T remove(int i) {
        int j = i + 1;
        if (isEmpty())
            throw new RuntimeException("堆为空");
        if (j < 1 || j > count)
            throw new RuntimeException("下标非法");
        T res = datas[indexes[j]];
        datas[indexes[j]] = datas[indexes[count]];
        datas[indexes[count--]] = null; // 防止对象游离
        sink(j);
        return res;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("堆为空");
        return datas[indexes[1]];
    }

    /**
     * 插入一个数据
     *
     * @param i    索引位置
     * @param data 数据
     */
    public void insert(int i, T data) {
        int j = i + 1;
        if (count == datas.length - 1)
            throw new RuntimeException("堆已满");
        if (j < 1 || j >= datas.length)
            throw new RuntimeException("下标非法");
        if (datas[j] == null) {
            datas[j] = data;
            indexes[count + 1] = j;
            count++;
            swim(count);
        } else datas[j] = data;

    }

    public T get(int i) {
        return datas[i + 1];
    }

    /**
     * 比较两个数，看谁上浮
     *
     * @param i 第一个数
     * @param j 第二个数
     * @return true 为i上浮， false 为j上浮
     */
    private boolean needSwim(int i, int j) {
        T a = datas[indexes[i]];
        T b = datas[indexes[j]];
        if (a == null)
            return false;
        if (b == null)
            return true;
        return comparator.compare(a, b) < 0;
    }

    private void exchange(int i, int j) {
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;
    }

    /**
     * 上浮
     *
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
     *
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
