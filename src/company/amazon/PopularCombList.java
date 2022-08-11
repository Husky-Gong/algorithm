package company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PopularCombList {
    public static void main(String[] args) {
        int n = 3;
        int[] popularity = new int[]{3,5,-2};
        int k = 3;

        int[] res = findKPopularCombList(n, popularity, k);
        List<Integer> res2 = findKPopularCombList2(n, popularity, k);
    }

    private static int[] findKPopularCombList(int n, int[] popularity, int k) {
        PriorityQueue<Integer> popularityComb = new PriorityQueue<>((a, b) -> b - a);

        backtrack(popularity, 0, 0, popularityComb);

        int i = 0;
        int[] res = new int[k];
        while (i < k) {
            res[i++] = popularityComb.poll();
        }
        return res;
    }

    private static void backtrack(int[] popularity, int idx, int sum, PriorityQueue<Integer> pq) {
        if (idx > popularity.length) return;
        pq.add(sum);

        for (int i = idx; i < popularity.length; i++) {
            sum += popularity[i];
            backtrack(popularity, i + 1, sum, pq);
            sum -= popularity[i];
        }
    }

    private static List<Integer> findKPopularCombList2(int n, int[] popularity, int k) {
        int posTotal = 0;
        List<Integer> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        for (int pop : popularity) {
            if (pop > 0) {
                posTotal += pop;
            }
        }

        for (int i = 0; i < popularity.length; i++) {
            popularity[i] = Math.abs(popularity[i]);
        }

        Arrays.sort(popularity);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{popularity[0], 0});
        int i = 0;
        while (!pq.isEmpty() && out.size() < k - 1) {
            int[] cur = pq.poll();
            int val = cur[0];
            int idx = cur[1];
            out.add(val);

            if (idx + 1 < n) {
                pq.add(new int[]{val + popularity[idx + 1], idx + 1});
                pq.add(new int[]{val - popularity[idx] + popularity[idx+1], idx + 1});
            }
        }

        ans.add(posTotal);
        for (int num : out) {
            ans.add(posTotal - num);
        }

        return ans;
    }
}
