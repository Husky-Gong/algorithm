package company.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KConsistencyScore {
    public static void main(String[] args) {
        int[] stockPrice = new int[]{1,1,2,1,2,1,2,1,1,1,1,2,1,1,2,1};
        int n = 16;
        int k = 4;

        int res = consistencyScore(n, stockPrice, k);

        System.out.println(res);
    }

    private static int consistencyScore(int n, int[] stockPrice, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxN = 0;

        while (right < n) {
            int cur = stockPrice[right];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            // 当前windows中出现次数最多的频率
            maxN = Math.max(maxN, map.get(cur));
            // 判断window是否满足条件 --> 删除的次数小于k
            if (right - left + 1 - maxN > k) {
                map.put(stockPrice[left], map.get(stockPrice[left]) - 1);
                left++;
            }

            right++;
        }
        // maxN 代表了当前windows中 出现频率最多的字符的次数
        return maxN;
    }
}
