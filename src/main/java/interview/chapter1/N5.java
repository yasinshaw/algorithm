package interview.chapter1;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 */
public class N5 {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!help.isEmpty() && temp > help.peek()) {
                stack.push(help.pop());
            }
            help.push(temp);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
