package company.apple;

public class StringJustifyOneLine {
    public static void main(String[] args) {
        String[] words = new String[]{"a","b","c","d"};
        String res = justifyStr(words, 11);
        System.out.println(res);
    }

    private static String justifyStr(String[] words, int maxWidth) {
        int numWords = words.length;

        // 计算字符总长度
        int sumLen = 0;
        for (String str : words) {
            sumLen += str.length();
        }

        // 计算平均空格长度
        int numSpace = maxWidth - sumLen;
        int avgSpace = numSpace / (numWords - 1);
        int extraSpace = numSpace % (numWords - 1);
        StringBuilder sb = new StringBuilder();

        // 先添加额外空格的
        sb.append(join(words, 0, extraSpace + 1, blank(avgSpace + 1)));
        sb.append(blank(avgSpace));
        // 再添加无需额外空格的
        sb.append(join(words, extraSpace + 1, words.length, blank(avgSpace)));
        return sb.toString();
    }

    private static String join(String[] words, int left, int right, String blanks) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[left]);

        for (int i = left + 1; i < right; i++) {
            sb.append(blanks);
            sb.append(words[i]);
        }
        return sb.toString();
    }

    private static String blank(int numSpace) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numSpace; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
