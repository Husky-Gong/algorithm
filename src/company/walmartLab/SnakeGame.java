package company.walmartLab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SnakeGame {
    public static void main(String[] args) {
        char[][] board1 = new char[][]{{'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}};
        List<Set<Integer>> list = passablePath(board1);

        char[][] board2 = new char[][]{{'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '+', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}};
        List<Set<Integer>> list2 = passablePath(board2);

        char[][] board3 = new char[][]{{'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '+', '0', '+', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}};
        List<Set<Integer>> list3 = passablePath(board3);

        char[][] board4 = new char[][]{{'+'}};
        List<Set<Integer>> list4 = passablePath(board4);
    }

    private static List<Set<Integer>> passablePath(char[][] board) {
        List<Set<Integer>> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            rows.add(i);
        }
        for (int j = 0; j < board[0].length; j++) {
            cols.add(j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '+') {
                    rows.remove(i);
                    cols.remove(j);
                }
            }
        }

        res.add(rows);
        res.add(cols);
        return res;
    }
}
