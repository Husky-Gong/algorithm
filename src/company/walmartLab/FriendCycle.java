package company.walmartLab;

import java.util.*;

public class FriendCycle {
    public static void main(String[] args) {
        String[] relationship = new String[]{"1,2", "1,3", "3,4"};
        String[] employees = new String[]{
                "1, Bill, Engineer",
                "2, Joe, HR",
                "3, Sally, Engineer",
                "4, Richard, Business",
                "6, Tom, Engineer"};
        Map<String, Set<String>> res = findFriendCycle(employees, relationship);
    }
    private static Map<String, Set<String>> findFriendCycle(String[] employees, String[] friendship) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String employee : employees) {
            String[] str = employee.split(",");
            String num = str[0];
            map.put(num, new HashSet<>());
        }
        for (String str: friendship) {
            String[] ppl = str.split(",");
            String ppl1 = ppl[0];
            String ppl2 = ppl[1];
            Set<String> set1 = map.get(ppl1);
            set1.add(ppl2);
            map.put(ppl1, set1);

            Set<String> set2 = map.get(ppl2);
            set2.add(ppl1);
            map.put(ppl2, set2);
        }
        return map;
    }
}
