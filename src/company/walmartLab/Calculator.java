package company.walmartLab;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        String test1 = "1+2-3+4";
        System.out.println(calculator1(test1));
        String test2 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculator2(test2));
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

    // 只包含 + - 和 ( )
    static int j = 0;
    private static int calculator2(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char presign = '+';

        while (j < s.length()) {
            char cur = s.charAt(j);
            j++;

            if (Character.isDigit(cur)) {
                num = num * 10 + (cur - '0');
            }
            if (cur == '(') {
                num = calculator2(s);
            }

            if (!Character.isDigit(cur) && cur != ' ' || j == s.length() || cur == ')') {
                if (presign == '+') {
                    stack.push(num);
                } else if (presign == '-') {
                    stack.push(-num);
                } else if (presign == '*') {
                    stack.push(stack.pop() * num);
                } else if (presign == '/') {
                    stack.push(stack.pop() / num);
                }
                // 更新符号
                presign = cur;
                num = 0;
            }
            if (cur == ')') break;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
