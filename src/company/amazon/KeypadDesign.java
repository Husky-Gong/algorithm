package company.amazon;

import java.util.*;

public class KeypadDesign {
    public static void main(String[] args) {
        String message = "hello";
        Map<Integer, List<Character>> res = getKeyPad(message);
    }

    private static Map<Integer, List<Character>> getKeyPad(String message) {
        Set<Character> miss = new HashSet<>();
        for (char i = 'a'; i <= 'z'; i++) {
            miss.add(i);
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : message.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            miss.remove(ch);
        }
        Map<Integer, List<Character>> map2 = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int num = entry.getValue();
            maxCount = Math.max(maxCount, num);
            List<Character> list = map2.getOrDefault(num, new ArrayList<>());
            list.add(ch);
            // 存储频率，以及该频率的字符
            map2.put(num, list);
        }
        Map<Integer, List<Character>> res = new HashMap<>();
        int idx = 1;

        for (int i = maxCount; i >= 1; i--) {
            if (map2.containsKey(i)) {
                // 将字符分摊到
                List<Character> list = map2.get(i);
                for (char cur : list) {
                    List<Character> keys = res.getOrDefault(idx, new ArrayList<>());
                    if (keys.size() < 3) {
                        keys.add(cur);
                    }
                    res.put(idx, keys);
                    idx = idx == 9 ? 1 : idx+1;
                }
            }
        }
        // 将count为0的放入keys
        for (char ch : miss) {
            List<Character> list = res.getOrDefault(idx, new ArrayList<>());
            if (list.size() < 3) {
                list.add(ch);
            }
            res.put(idx, list);
            idx = idx == 9 ? 1 : idx + 1;
        }

        return res;
    }
}
