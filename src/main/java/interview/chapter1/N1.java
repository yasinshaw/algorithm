package interview.chapter1;

import java.util.Stack;

/**
 * 设计一个带有getMin功能的栈
 */
public class N1 {
    private Stack<Integer> data;
    private Stack<Integer> min;


    public void push(int newNum) {
        if (min.isEmpty()) {
            min.push(newNum);
        } else {
            min.push(Math.min(min.peek(), newNum));
        }
        data.push(newNum);
    }

    public int pop() {
        min.pop();
        return data.pop();
    }

    public int getMin() {
        return min.peek();
    }
}
