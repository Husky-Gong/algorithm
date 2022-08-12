package company.amazon;

import java.util.HashMap;
import java.util.Map;

public class StockCumulativeOvervableSum {
    public static void main(String[] args) {
        int[] stock = new int[]{1,2,7,7,4,3,6};
        int k = 3;

        int res = findStockCumulativeSum(stock, k);
        System.out.println(res);
    }

    private static int findStockCumulativeSum(int[] stock, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, right = 0;

        int sum = 0;
        int res = 0;
        while (right < stock.length) {
            int cur = stock[right];
            // 先将cur加入，再移动left 修改window
            count.put(cur, count.getOrDefault(cur, 0) + 1);
            sum += stock[right];
            if (count.get(stock[right]) <= 1) {
                res = Math.max(sum, res);
            }
            // 移动window 的left
            while (left < right && count.get(cur) > 1 || right - left + 1 >= k) {
                count.put(stock[left], count.get(stock[left]) - 1);
                sum -= stock[left];
                left++;
            }
            right++;
        }

        return res;
    }
}
