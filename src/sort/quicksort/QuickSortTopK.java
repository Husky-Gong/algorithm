package sort.quicksort;

import java.util.ArrayList;
import java.util.List;

public class QuickSortTopK {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,5,6,3,7,3,0};
        int k = 5;
        List<Integer> res = sortArray(arr, k);
        for (int num : res) {
            System.out.println(num);
        }
    }

    /**
     * 1. use right as temp pivot
     * 2. find actual index for the temp pivot
     * 3. if index == k -> left is sorted and return
     *      else if index > k -> quicksort(arr, left, index - 1)
     *      else index < k -> quicksort(arr, index + 1, left)
     *
     * a. swap(arr, left, right)
     * b. partition(arr, left, right)
     */

    public static List<Integer> sortArray(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return new ArrayList<>();
        }

        quicksort(arr, 0, arr.length - 1, arr.length - k);

        List<Integer> res = new ArrayList<>();

        for (int i = arr.length - k; i < arr.length; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    private static void quicksort(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);
        if (pivotIndex == k) {
            return;
        } else if (pivotIndex < k) {
            quicksort(arr, pivotIndex + 1, right, k);
        } else {
            quicksort(arr, left, pivotIndex - 1, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left, j = right - 1;

        while (i <= j) {
            if (arr[i] <= pivot) {
                i++;
            } else if (arr[j] >= pivot) {
                j--;
            } else {
                swap(arr, left++, right--);
            }
        }

        swap(arr, i, pivot);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
