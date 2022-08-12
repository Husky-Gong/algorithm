package company.amazon;

import java.util.HashMap;
import java.util.Map;

public class AWSProcessor {
    public static void main(String[] args) {
        int[] times = new int[]{5,5,3,6,5,3};
        int n = times.length;
        int res = getProcessTime(n, times);
        System.out.println(res);
    }

    private static int getProcessTime(int n, int[] times) {
        Map<Integer, Integer> orig2curr = new HashMap<>();

        for (int time : times) {
            orig2curr.put(time, time);
        }

        int totalTime = 0;
        for (int i = 0; i < times.length; i++) {
            totalTime += orig2curr.get(times[i]);
            orig2curr.put(times[i], (int) Math.ceil(orig2curr.get(times[i]) / 2.0));
        }
        return totalTime;
    }
}
