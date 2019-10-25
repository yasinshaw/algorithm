package leetcode.explore.medium.dynamic_planning;

public class N1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                boolean canJump = false;
                for (int j = i - 1; j >= 0; j--) {
                    if ((nums[j] + j > i) || nums[j] + j >= n - 1) {
                        canJump = true;
                        break;
                    }
                }
                if (!canJump) {
                    return false;
                }
            }
        }
        return true;
    }
}
