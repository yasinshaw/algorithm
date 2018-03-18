package queue;

/**
 * 队列接口
 */
public interface IQueue<T> {
    void offer(T data); // 入队
    T peek(); // 取队首元素
    T poll(); // 出队
    int size(); // 队列长度
    boolean isEmpty(); // 队列判空
}
