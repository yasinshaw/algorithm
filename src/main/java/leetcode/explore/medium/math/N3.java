package leetcode.explore.medium.math;

public class N3 {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int k = getIntFromChar(chars[i]);
            result += k * Math.pow(26, n - 1 - i);
        }
        return result;
    }

    private int getIntFromChar(char c) {
        return c - 'A' + 1;
    }
}
