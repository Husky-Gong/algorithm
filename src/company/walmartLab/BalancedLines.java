package company.walmartLab;

import java.util.ArrayList;
import java.util.List;

public class BalancedLines {
    public static void main(String[] args) {
        String[] words = new String[]{"123", "45", "67", "8901234", "5678", "12345", "8", "9", "0", "1", "23"};
        List<String> res = balanceLines(words, 15);
    }

    private static List<String> balanceLines(String[] words, int maxLength) {
        List<String> res = new ArrayList<>();
        int right = 0;
        int n = words.length;

        while (true) {
            int left = right; // 当前行第一个单词的index
            int sumLen = 0;

            // 找出 能放多少单词
            while (right < n && sumLen + words[right].length() + (right - left) <= maxLength) {
                sumLen += words[right++].length();
            }
            // 如果是最后一行，只有一个单词，直接加入并且返回结果
            if (right == n) {
                String sb = join(words, left, n, "-");
                res.add(sb.toString());
                return res;
            }
            // 计算当前行有多少的单词
            int numWords = right - left;
            int numDash = maxLength - sumLen;

            // 如果只有一个单词，则直接加入结果
            if (numWords == 1) {
                res.add(words[left]);
                continue;
            }

            // 当不只一个单词时候，需要使用-进行连接
            int avgDash = numDash / (numWords - 1);
            int extraDash = numDash % (numWords - 1);
            StringBuilder sb = new StringBuilder();
            // 前面的需要多加- 的那部分单词
            sb.append(join(words, left, left + extraDash + 1, dash(avgDash + 1)));
            // 连接 -
            sb.append(dash(avgDash));
            // 连接 平均 - 的那些单词
            sb.append(join(words, left + extraDash + 1, right, dash(avgDash)));
            res.add(sb.toString());
        }
    }

    private static String dash(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('-');
        }
        return sb.toString();
    }

    private static String join(String[] words, int left, int right, String dashes) {
        StringBuilder sb = new StringBuilder(words[left]);
        for (int i = left + 1; i < right; i++) {
            sb.append(dashes);
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
