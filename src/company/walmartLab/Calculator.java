package company.walmartLab;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        String test1 = "1+2-3+4";
        System.out.println(calculator1(test1));
    }
    // 只包含 + -
    private static int calculator1(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char presign = '+';

        while (i < s.length()) {
            char cur = s.charAt(i);
            i++;

            if (Character.isDigit(cur)) {
                num = num * 10 + (cur - '0');
            }

            if (!Character.isDigit(cur) && cur != ' ' || i == s.length()) {
                if (presign == '+') {
                    stack.push(num);
                } else if (presign == '-') {
                    stack.push(-num);
                }
                // 更新符号
                presign = cur;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
