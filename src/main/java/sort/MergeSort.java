package sort;

import java.util.Random;

public class MergeSort {
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        if (n1 >= 0) System.arraycopy(arr, left, L, 0, n1);
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i++];
            } else{
                arr[k] = R[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(100);
        }
        mergeSort(arr, 0, arr.length - 1);
        for (int value : arr) {
            System.out.println(value);
        }
    }
}
