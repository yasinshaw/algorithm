package heap;

/**
 * 堆接口
 */
public interface IHeap<T> {
    int size(); // 当前元素的长度
    boolean isEmpty(); // 判空
    void add(T data); // 添加
    T pop(); // 弹出堆顶元素
    T remove(int i); // 移除某位置元素
    T peek(); // 过去堆顶元素
}
