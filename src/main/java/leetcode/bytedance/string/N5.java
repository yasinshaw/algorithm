package leetcode.bytedance.string;

import java.util.Stack;

/**
 * 翻转字符串里的单词
 */
public class N5 {
    public String reverseWords(String s) {
        int length = s.length();
        if (length < 1) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0, j;
        while (i < length) {
            while (i < length && chars[i] == ' ') {
                i++;
            }
            j = i;
            while (j < length && chars[j] != ' ') {
                j++;
            }
            if (i < length) {
                stack.push(s.substring(i, j));
                i = j;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        N5 demo = new N5();
        String res = demo.reverseWords(" ");
        System.out.println(res);
    }
}
