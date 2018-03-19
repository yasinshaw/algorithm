package stack;

public interface IStack<T> {
    void push(T data); // 入栈
    T peek(); // 取栈顶元素
    T pop(); // 出栈
    int size(); // 长度
    boolean isEmpty(); // 是否为空
}
