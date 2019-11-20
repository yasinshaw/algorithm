package interview.chapter1;

import java.util.Stack;

/**
 * 用栈来解决汉诺塔问题
 */
public class N6 {

    private static final int NO_ACTION = 0;
    private static final int L_2_M = 1;
    private static final int M_2_L = 2;
    private static final int R_2_M = 3;
    private static final int M_2_R = 4;

    private int preAction = NO_ACTION;
    private Stack<Integer> left = new Stack<>();
    private Stack<Integer> mid = new Stack<>();
    private Stack<Integer> right = new Stack<>();

    public int hanoiProblem(int num) {

        left.push(Integer.MAX_VALUE);
        mid.push(Integer.MAX_VALUE);
        right.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            left.push(i);
        }
        int step = 0;
        while (right.size() != num + 1) {
            step += this.tryMove();
        }
        return step;
    }

    private int tryMove() {
        if (this.preAction == NO_ACTION) {
            System.out.println(String.format("move %d from left to mid", left.peek()));
            mid.push(left.pop());
            this.preAction = L_2_M;
            return 1;
        } else if (this.preAction == L_2_M || this.preAction == M_2_L) {
            if (mid.peek() < right.peek()) {
                System.out.println(String.format("move % d from mid to right", mid.peek()));
                right.push(mid.pop());
                this.preAction = M_2_R;
                return 1;
            } else {
                System.out.println(String.format("move % d from right to mid", right.peek()));
                mid.push(right.pop());
                this.preAction = R_2_M;
                return 1;
            }
        } else if (this.preAction == M_2_R || this.preAction == R_2_M) {
            if (mid.peek() < left.peek()) {
                System.out.println(String.format("move % d from mid to left", mid.peek()));
                left.push(mid.pop());
                this.preAction = M_2_L;
                return 1;
            } else {
                System.out.println(String.format("move % d from left to mid", left.peek()));
                mid.push(left.pop());
                this.preAction = L_2_M;
                return 1;
            }
        }
        return 0;
    }
}
