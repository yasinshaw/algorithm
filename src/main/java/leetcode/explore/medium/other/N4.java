package leetcode.explore.medium.other;

import java.util.Arrays;

public class N4 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int max = map[25];
        int slots = (max - 1) * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            slots -= Math.min(map[i], max - 1);
        }
        return slots > 0 ? slots + tasks.length : tasks.length;
    }
}
