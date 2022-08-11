package company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KLowestInefficentyTeams {
    public static void main(String[] args) {
        int[] skills = new int[]{6, 9, 1};
        int n = 3;
        int k = 2;
        int[] res = findKSmallestPair(skills, k);
    }

    public static int[] findKSmallestPair(int[] nums, int k) {
        int[] res = new int[k];
        for (int i = 1; i <= k; i++) {
            res[i-1] = smallestDistancePair(nums, i);
        }
        return res;
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length-1] - nums[0];

        while(low<=high){
            int mid = low + (high-low)/2;
            if(noOfDistancesLessThan(mid,nums) >= k) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    private static int noOfDistancesLessThan(int dist,int[] nums){
        int count = 0,i = 0, j = 0;
        while(i<nums.length){
            while(j<nums.length && nums[j]-nums[i]<=dist){  // sliding window
                j++;
            }
            count += j-i-1;
            i++;
        }
        return count;
    }
}

