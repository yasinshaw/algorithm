package interview.chapter1;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 */
public class N3 {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(last);
    }

    private static int getAndRemoveLast(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int last = getAndRemoveLast(stack);
        stack.push(result);
        return last;
    }
}
