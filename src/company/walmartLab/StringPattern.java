package company.walmartLab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringPattern {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "dada", "breath" , "taking", "doll"};
        String pattern1 = "drctkla";
        String pattern2 = "rdatlbohe";

        String res1 = findFirstPattern(words, pattern1);
        String res2 = findFirstPattern(words, pattern2);
        System.out.println("res1:" + res1 + "   res2:" + res2);
    }

    private static String findFirstPattern(String[] words, String pattern) {
        if (words == null || words.length == 0) return "-";

        for (String word : words) {
            if (findWord(word, pattern)) {
                return word;
            }
        }
        return "-";
    }
    // word为短的，pattern为长的
    private static boolean findWord(String word, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        // 找出word构成的字符个数
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // 再构建一个pattern对应的字符个数
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        // 再判断两个map是否是包含关系
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if (!patternMap.containsKey(ch) || (patternMap.containsKey(ch) && count > patternMap.get(ch))) {
                return false;
            }
        }

        return true;
    }
}
