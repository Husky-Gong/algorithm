package company.amazon;

import java.util.HashMap;
import java.util.Map;

public class ConsecutiveStr {
    public static void main(String[] args) {
        String[] words = new String[]{"abc", "bcd", "ace", "bdf", "aaa", "bbb", "abc"};
        int res = getConsecutivePair(words);
        System.out.println(res);
    }

    private static int getConsecutivePair(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int res = 0;
        for (String str : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : str.toCharArray()) {
                sb.append((char) (ch + 1));
            }
            if (map.containsKey(sb.toString())) {
                res += map.get(sb.toString());
            }
        }

        return res;
    }
}
