package company.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosetRestaurant {
    public static void main(String[] args) {
        int[][] restaurants = new int[][]{{1,2}, {3,4}, {1,-1}};
        int[][] res = getNearestRestaurant(restaurants, 2);
    }

    private static int[][] getNearestRestaurant(int[][] restaurants, int num) {
        int[][] res = new int[num][2];

        // use top k to find the nearest restaurants, from large to small
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]*a[0] + a[1]*a[1]) == (b[0]*b[0] + b[1]*b[1]) ? (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]) : (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for (int[] restaurant : restaurants) {
            pq.offer(restaurant);
            if (pq.size() > num) {
                pq.poll();
            }
        }

        // get result
        int i = num - 1;
        while (!pq.isEmpty()) {
            res[i] = pq.poll();
            i--;
        }

        return res;
    }
}
