package leetcode.explore.medium.dynamic_planning;

/**
 * 找到元素为0的位置i，往左边查，看是否有能够越过这个位置的数
 * 即nums[j] + j > i,如果不能找到任意一个j，就返回false。
 */
public class N2 {
    public int uniquePaths(int m, int n) {
        int[][] stepNums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    stepNums[i][j] = 1;
                } else {
                    stepNums[i][j] = stepNums[i - 1][j] + stepNums[i][j - 1];
                }
            }
        }
        return stepNums[n - 1][m - 1];
    }
}
