package interview.chapter1;

import java.util.Stack;

/**
 * 用栈实现队列的功能
 */
public class N2 {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public N2() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(int num) {
        this.pushStack.push(num);
    }

    public int poll() {
        tryReverse();
        return popStack.peek();
    }

    public int pop() {
        tryReverse();
        return popStack.pop();
    }

    private void tryReverse() {
        if (this.popStack.isEmpty()) {
            if (this.pushStack.isEmpty()) {
                throw new RuntimeException();
            } else {
                while (!pushStack.isEmpty()) {
                    this.popStack.push(pushStack.pop());
                }
            }
        }
    }

}
