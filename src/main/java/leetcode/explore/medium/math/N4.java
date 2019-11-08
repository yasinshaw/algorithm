package leetcode.explore.medium.math;

public class N4 {
    public double myPow(double x, int n) {
        int N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
