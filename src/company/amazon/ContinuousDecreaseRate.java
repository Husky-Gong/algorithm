package company.amazon;

public class ContinuousDecreaseRate {
    public static void main(String[] args) {
        int[] input = new int[]{4,3,5,4,3};
        int res = getCountinuousDecreaseSubarray(input);
        System.out.println(res);
    }

    private static int getCountinuousDecreaseSubarray(int[] arr) {
        int left = 0, right = 0;
        int res = 0;

        while (right < arr.length) {
            //
            if (left == right) {
                res++;
                right++;
            } else {
                // 找右边边界，每多一个值，我们的结果就多right-left+1个
                while (right < arr.length && arr[right] < arr[right - 1]) {
                    res += right - left + 1;
                    right++;
                }
                // 不满足条件时，更新左边界
                left = right;
            }
        }

        return res;
    }
}
