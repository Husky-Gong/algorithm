package company.walmartLab;

import java.util.ArrayList;
import java.util.List;

public class WrapLine {
    public static void main(String[] args) {
        String[] words1 = new String[]{"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        List<String> res1 = wrapLines(words1, 4);
    }

    private static List<String> wrapLines(String[] words, int maxLength) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            String word = words[i];
            if (sb.length() == 0) {
                if (word.length() >= maxLength) {
                    res.add(word);
                } else {
                    sb.append(word);
                }
                i++;
            } else {
                if (sb.length() + 1 + word.length() <= maxLength) {
                    sb.append("-");
                    sb.append(word);
                    i++;
                } else {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.length() != 0) {
            res.add(sb.toString());
        }

        return res;
    }
}
