package leetcode.explore.medium.math;

public class N5 {
    public int mySqrt(int x) {
        double r = 1.0;
        while (Math.abs(r * r - x) > 0.5) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}
