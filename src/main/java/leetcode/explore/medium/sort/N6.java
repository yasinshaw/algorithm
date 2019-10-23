package leetcode.explore.medium.sort;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class N6 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = Arrays.asList(intervals);
        list.sort(Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> result = new LinkedList<>();
        list.forEach(item -> {
            if (result.isEmpty() || result.getLast()[1] < item[0]) {
                result.add(item);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], item[1]);
            }
        });
        int[][] arr = new int[result.size()][2];
        return result.toArray(arr);
    }
}
