package company.amazon;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFrequencyByIndex_simulation {
    public static void main(String[] args) {
        char[] chars = "abbcca".toCharArray();
        int res = getMaxFrequency(chars);
        System.out.println(res);
    }

    private static int getMaxFrequency(char[] arr) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            // 计数
            char cur = arr[i];
            count.put(cur, count.getOrDefault(cur, 0) + 1);
            if (stack.isEmpty()) {
                stack.push(new Pair<>(cur, count.get(cur)));
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            } else {
                while (!stack.isEmpty() && count.get(cur) > stack.peek().getValue()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek().getValue() <= count.get(cur)) {
                    stack.push(new Pair<>(cur, count.get(cur)));
                }
                for (Pair<Character, Integer> pair : stack) {
                    map.put(pair.getKey(), map.getOrDefault(pair.getKey(), 0) + 1);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res = Math.max(entry.getValue(), res);
        }
        return res;
    }
}
