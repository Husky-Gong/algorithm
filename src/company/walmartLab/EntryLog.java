package company.walmartLab;

import javafx.util.Pair;

import java.util.*;

public class EntryLog {
    public static void main(String[] args) {
        String[][] logs1 = new String[][]{
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"}};
        getFirstLastTime(logs1);
        getMaxRecord(logs1);
        System.out.println("----------------");
        String[][] logs2 = new String[][]{
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}};
        getFirstLastTime(logs2);
        getMaxRecord(logs2);
    }

    private static void getFirstLastTime (String[][] logs) {
        Map<String, int[]> map = new HashMap<>();
        for (String[] log : logs) {
            int time = Integer.parseInt(log[0]);
            String user = log[1];
            String resource = log[2];
            if (!map.containsKey(user)) {
                int[] record = new int[]{time, time};
                map.put(user, record);
            } else {
                int firstTime = map.get(user)[0];
                int lastTime = map.get(user)[1];
                if (time > lastTime) {
                    lastTime = time;
                }
                if (time < firstTime) {
                    firstTime = time;
                }
                int[] record = new int[]{firstTime, lastTime};
                map.put(user, record);
            }
        }
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            System.out.println("name : " + entry.getKey() + " FirstTime : " + entry.getValue()[0] + " LastTime : " + entry.getValue()[1]);
        }
    }

    private static void getMaxRecord(String[][] logs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String[] log : logs) {
            int time = Integer.parseInt(log[0]);
            String resource = log[2];
            List<Integer> list = map.getOrDefault(resource, new ArrayList<>());
            list.add(time);
            map.put(resource, list);
        }
        // 排序 找5分钟内的最多次数
        Pair<String, Integer> pair = new Pair<>(null, 0);
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            int maxAccess = 0;
            for (int i = 0; i < list.size(); i++) {
                int j = i;
                int count = 0;
                while (j < list.size() && list.get(j) <= list.get(i) + 300) {
                    count++;
                    j++;
                }
                maxAccess = Math.max(maxAccess, count);
            }
            if (pair.getKey() == null || maxAccess > pair.getValue()) {
                pair = new Pair<>(entry.getKey(), maxAccess);
            }
        }

        System.out.println("Resource : " + pair.getKey() + " Count : " + pair.getValue());
    }
}
