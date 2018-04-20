package search;

/**
 * 二分查找
 * @author yasin
 * @version v1.0
 * @date 2018/4/20
 */
public class BinarySearch {

    /**
     * 查找
     * @param sortedArray 已排序好的数组
     * @param key 需要查找的key
     * @return key 所在的位置
     */
    public static <T extends Comparable<T>> int search(T[] sortedArray, T key) {
        // 在[lo..hi]范围查找
        int lo = 0, hi = sortedArray.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // 防止int越界bug
            int cmp = key.compareTo(sortedArray[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return -1; // 如果没有找到就返回-1。
    }
}
