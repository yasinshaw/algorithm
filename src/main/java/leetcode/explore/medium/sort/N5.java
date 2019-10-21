package leetcode.explore.medium.sort;

import java.util.Arrays;

/**
 * user binary search thought, find the border
 * task:
 * for an array range, find its middle item,
 *  if the range length is 1, and the sole item is equals the target, return its index, else, return -1;
 *  if it's equals the target, try to find its left border in the left range, and its right border in the right range
 *  if it's less than the target, try to repeat this way in right range;
 *  if it's grater than the target, try to repeat this way in left range;
 */
public class N5 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // find first target in nums[l, r]
        int left = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                left = m;
                r = m - 1;
            }
            else if (target < nums[m]) {
                r = m - 1; // find in nums[l, m - 1]
            }
            else {
                l = m + 1; // find in nums[m + 1, r]
            }
        }
        return left;
    }

    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // find last target in nums[l, r]
        int right = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                right = m;
                l = m + 1;
            }
            else if (target > nums[m]) {
                l = m + 1; // find in nums[m + 1, r]
            }
            else {
                r = m - 1; // find in nums[l, m - 1]
            }
        }
        return right;
    }

    public static void main(String[] args) {
        N5 solution = new N5();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{2, 2}, 2)));

    }

}
