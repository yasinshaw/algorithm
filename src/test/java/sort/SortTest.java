package sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class SortTest {
    private Integer[] arr;
    private Integer[] sortedArr;

    /**
     * 初始化数组
     */
    @Before
    public void initArray() {
        arr = new Integer[200];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        sortedArr = new Integer[200];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
    }

    /**
     * 检查数组是否排好序
     */
    @After
    public void checkArray() {
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    public void insertSort() {
        Sort.insertSort(arr);
    }

    @Test
    public void selectSort() {
        Sort.selectSort(arr);
    }

    @Test
    public void bubbleSort() {
        Sort.bubbleSort(arr);
    }

    @Test
    public void shellSort() {
        Sort.shellSort(arr);
    }
    @Test
    public void mergeSort() {
        Sort.mergeSort(arr);
    }

    @Test
    public void quickSort() {
        Sort.quickSort(arr);
    }
}