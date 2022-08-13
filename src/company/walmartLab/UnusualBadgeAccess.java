package company.walmartLab;

import java.util.*;

public class UnusualBadgeAccess {
    public static void main(String[] args) {
        String[][] badgeTime = new String[][]
                {{"Paul", "1355"}, {"Jennifer", "1910"}, {"Jose", "835"},
                {"Jose", "830"}, {"Paul", "1315"}, {"Chloe", "0"},
                {"Chloe", "1910"}, {"Jose", "1615"}, {"Jose", "1640"},
                {"Paul", "1405"}, {"Jose", "855"}, {"Jose", "930"},
                {"Jose", "915"}, {"Jose", "730"}, {"Jose", "940"},
                {"Jennifer", "1335"}, {"Jennifer", "730"}, {"Jose", "1630"},
                {"Jennifer", "5"}, {"Chloe", "1909"}, {"Zhang", "1"},
                {"Zhang", "10"}, {"Zhang", "109"}, {"Zhang", "110"},
                {"Amos", "1"}, {"Amos", "2"}, {"Amos", "400"},
                {"Amos", "500"}, {"Amos", "503"}, {"Amos", "504"},
                {"Amos", "601"}, {"Amos", "602"}, {"Paul", "1416"}};
        String[][] badgeTime2 = new String[][]{
                {"Jose", "835"},{"Jose", "830"},{"Jose", "1615"},
                {"Jose", "1640"},{"Jose", "855"}, {"Jose", "930"},
                {"Jose", "915"}, {"Jose", "730"}, {"Jose", "940"},
                {"Jose", "1630"}};
        Map<String, List<Integer>> map = getUnusualAccess(badgeTime);
    }

    private static Map<String, List<Integer>> getUnusualAccess(String[][] records) {
        Arrays.sort(records, (a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

        Map<String, List<Integer>> map = new HashMap<>();
        for (String[] record : records) {
            String name = record[0];
            int time = Integer.parseInt(record[1]);
            List<Integer> list = map.getOrDefault(name, new ArrayList<>());
            list.add(time);
            map.put(name, list);
        }

        Map<String, List<Integer>> res = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            int left = 0, right = 0;
            while (!res.containsKey(name) && right < times.size()) {
                while (right < times.size() && times.get(right) - times.get(left) <= 100) {
                    right++;
                }
                if (right - left >= 3) {
                    List<Integer> list = new ArrayList<>();
                    for (int i = left; i < right; i++) {
                        list.add(times.get(i));
                    }
                    res.put(name, list);
                }
                left++;
            }
        }

        return res;
    }
}
