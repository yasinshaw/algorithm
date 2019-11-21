package interview.chapter1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 生成窗口最大值数组
 */
public class N7 {
    public List<Integer> getMaxWindow(int[] arr, int w) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>(arr.length - w + 1);
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) {
                queue.pollLast();
            }
            queue.addLast(arr[i]);
            if (i >= w - 1) {
                result.add(queue.peekFirst());
            }
        }
        return result;
    }
}
