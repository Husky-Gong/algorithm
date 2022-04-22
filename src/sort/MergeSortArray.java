package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,5,1,2,6,4};
        List<Integer> res = sortArray(arr1);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static List<Integer> sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int[] help = new int[nums.length];

        mergesort(nums, help, 0, nums.length - 1);

        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            result.add(num);
        }

        return result;
    }

    /**
     *
     * @param nums : original array
     * @param help : sorted result array
     * @param left : left index
     * @param right : right index
     */
    private static void mergesort(int[] nums, int[] help, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergesort(nums, help, left, mid);
        mergesort(nums, help, mid + 1, right);

        sort(nums, help, left, mid, right);
    }

    private static void sort(int[] nums, int[] help, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int index = left;

        for (int k = left; k <= right; k++) {
            help[k] = nums[k];
        }

        while (i <= mid && j <= right) {
            if (help[i] < help[j]) {
                nums[index++] = help[i++];
            } else {
                nums[index++] = help[j++];
            }
        }

        // remaining unsorted part
        while (i <= mid) {
            nums[index++] = help[i++];
        }
    }
}
