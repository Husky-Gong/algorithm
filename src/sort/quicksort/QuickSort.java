package sort.quicksort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,0,3,4,9,0,3,1};
        sortArray(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    // 1. get an unsorted pivot
    // 2. get sorted pivot
    // 3. partition into left and right

    public static List<Integer> sortArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }

        quicksort(nums, 0, nums.length - 1);

        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }

        return res;
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);

        quicksort(arr, left, pivotIndex - 1);
        quicksort(arr, pivotIndex + 1, right);
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
                swap(arr, i++, j--);
            }
        }

        swap(arr, i, right);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
