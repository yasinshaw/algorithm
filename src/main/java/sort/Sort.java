package sort;

/**
 * 排序算法
 */
public class Sort {
/**
 * 插入排序
 * 1. 维护arr[0..i)为有序数组
 * 2. 取得arr[i], 把它插入到前面的有序数组中的合适的位置
 * 3. i从1遍历到n - 1
 * @param arr 要排序的数组
 * @param <T> 类型
 */
public static <T extends Comparable> void insertSort(T[] arr) {
    T temp;
    for (int i = 1; i < arr.length; i++) {
        int j = i;
        // 这里做了一个优化,先找到位置,再一次性交换.而不是一个个交换过去.
        while (j >0 && less(arr, i, j - 1))
            j--;
        temp = arr[i];
        System.arraycopy(arr, j, arr, j + 1, i - j);
        arr[j] = temp;
    }
}

/**
 * 选择排序
 * 1. 维护arr[0..i)有序
 * 2. 每次从arr[i..n)中取得最小值arr[j]
 * 3. 交换arr[i]和arr[j]
 * 4. i从0到n - 1 遍历
 * @param arr 要排序的数组
 * @param <T> 类型
 */
public static <T extends Comparable> void selectSort(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
        int min = i; // 最小值的索引
        for (int j = i; j < arr.length; j++) {
            if (less(arr, j, min)) {
                min = j;
            }
        }
        // 交换i和min位置的元素
        if (i != min) {
            exchange(arr, i, min);
        }
    }
}

/**
 * 冒泡排序
 * 1. 维持[0..i)有序
 * 2. 从数组末尾n - 1 位置到 i 位置, 每个元素与上一个元素比较,若小于,则两个元素交换.
 * 3. 经过一趟2之后,最后到了i出, arr[i]就是[i..n - 1]最小的元素
 * 优化：设置一个标记变量flag，当循环中没有交换数据时，算法将停止循环。
 * 冒泡排序是一种交换排序.
 * @param arr 要排序的数组
 * @param <T> 类型
 */
public static <T extends Comparable> void bubbleSort(T[] arr) {
    boolean flag = true; // 本趟冒泡是否发生了交换
    for (int i = 0; i < arr.length && flag; i++) {
        flag = false;
        for (int j = arr.length - 1; j > i; j--) {
            if (less(arr, j, j - 1)) {
                flag = true;
                exchange(arr, j, j - 1);
            }
        }
    }
}

/**
 * 希尔排序
 * 1. 修改插入排序算法,使数组每隔k个数的子数列有序
 * 2. 逐步缩小k,最后缩小到1,整个数组有序.
 * 3. 需要注意的是这时不能使用插入排序的优化方法,因为不能直接简单地arraycopy
 * @param arr 要排序的数组
 * @param <T> 类型
 */
public static <T extends Comparable> void shellSort(T[] arr) {
    for(int k = arr.length / 2; k > 0; k /= 2) {
        for (int i = k; i < arr.length; i += k) {
            for (int j = i; j >= k && less(arr, j, j - k); j -= k) {
                exchange(arr, j, j - k);
            }
        }
    }
}

/**
 * 归并排序
 * 1. 假设[lo..mid]与[mid+1..hi]均排好序,
 * 2. 合并上述排好序的数组,组成一个新的有序数组
 * 3. 当子数组长度为1时,自然是已经排好序的.
 * 4. 使用递归算法重复上述过程
 * @param arr 要排序的数组
 * @param <T> 类型
 */
public static <T extends Comparable> void mergeSort(T[] arr) {
    mergeSort(arr, 0, arr.length - 1);
}

/**
 * 归并排序的递归过程
 * @param arr  整个数组
 * @param lo 低位
 * @param hi 高位
 * @param <T> 类型
 */
private static <T extends Comparable> void mergeSort(T[] arr, int lo, int hi) {
    // 设置递归临界条件
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2; // 防止边界溢出
    mergeSort(arr, lo, mid);
    mergeSort(arr, mid + 1, hi);
    merge(arr, lo, mid, hi); // 合并
}

/**
 * 归并排序的一趟合并过程.其中arr[lo..mid]和arr[mid + 1..hi]已经排好序
 * @param arr 数组
 * @param lo 低位
 * @param mid 中位
 * @param hi 高位
 * @param <T> 类型
 */
private static <T extends Comparable> void merge(T[] arr, int lo, int mid, int hi) {
    // 计算两边的长度和总长度
    int lLen = mid - lo + 1;
    int rLen = hi - mid;
    int n = lLen + rLen;
    Comparable[] temp = new Comparable[n];
    System.arraycopy(arr, lo, temp, 0, n);
    // 三个指针,i为左边数组当前位置,j为右边数组当前位置,k为最终数组当前位置
    for (int i = 0, j = lLen, k = lo; k <= hi; k++) {
        if (i >= lLen) arr[k] = (T) temp[j++];
        else if (j >= n ) arr[k] = (T) temp[i++];
        else if (less(temp, i, j)) arr[k] = (T) temp[i++];
        else arr[k] = (T) temp[j++];
    }
}

/**
 * 快速排序
 * 1. 选取某一个元素为flag, 比flag小的放到左边,比flag大的放到右边.可以选取flag为第一个元素.
 * 2. 利用递归思想,对左边的数组和右边的数组分别重复上述过程,逐渐缩小待排序数组的范围,直到为1,此时整个数组已经排好序
 * @param arr 要排序的数组
 * @param <T> 类型
 */
public static <T extends Comparable> void quickSort(T[] arr) {
    quickSort(arr, 0, arr.length - 1);
}

/**
 * 快速排序归并方法
 * @param arr 要排序的数组
 * @param lo 低位
 * @param hi 高位
 * @param <T> 类型
 */
private static <T extends Comparable> void quickSort(T[] arr, int lo, int hi) {
    if (hi <= lo) return;
    int p = partition(arr, lo, hi); // 一趟切分
    quickSort(arr, lo, p - 1);
    quickSort(arr,p + 1, hi);
}

/**
 * 一趟快速排序的切分
 * 1. 设置支点为arr[lo]
 * 2. 设置两个指针i, j, 从两端到中间扫描
 * 3. 先从左边向右扫描,如果发现arr[i]比支点大,停下来.
 * 4. 再从右边向左边扫描,如果发现arr[j]比支点小,停下来.
 * 5. 交换arr[i]与arr[j],继续向后扫描.直到 i >= j
 * @param arr 整个数组
 * @param lo 低位
 * @param hi 高位
 * @return 支点的位置
 */
private static <T extends Comparable> int partition(T[] arr, int lo, int hi) {
    //左右扫描指针,注意初始化的条件,是因为下面的扫描是先移动再比较.比如++i --j
    int i = lo, j = hi + 1;
    while (true) {
        while (less(arr, ++i, lo))
            if (i == hi) break;
        while (less(arr, lo, --j))
            if (j == lo) break;
        if (i >= j) break;
        exchange(arr, i, j);
    }
    exchange(arr, lo, j); // 这里是j而不是i,因为到最后总是j <= i 的
    return j;
}



/**
 * 交换两个元素
 * @param arr 数组
 * @param a 第一个位置
 * @param b 第二个位置
 * @param <T> 类型
 */
private static <T> void exchange(T[] arr, int a, int b) {
    T temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

/**
 * 比较两个元素
 * @param arr 数组
 * @param a 第一个位置
 * @param b 第二个位置
 * @param <T> 类型
 * @return arr[a]是否小于arr[b]
 */
private static <T extends Comparable> boolean less(T[] arr, int a, int b) {
    return arr[a].compareTo(arr[b]) < 0;
}
}
