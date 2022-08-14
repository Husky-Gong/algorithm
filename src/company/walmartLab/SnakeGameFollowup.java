package company.walmartLab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeGameFollowup {
    public static void main(String[] args) {
        char[][] board1 = new char[][]{{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}};
        int[] enter1 = new int[]{2, 0};
        int[] res1 = getExitPort(board1, enter1);
        int[] enter2 = new int[]{0, 7};
        int[] res2 = getExitPort(board1, enter2);
        int[] enter3 = new int[]{5, 2};
        int[] res3 = getExitPort(board1, enter3);
        int[] enter4 = new int[]{5, 5};
        int[] res4 = getExitPort(board1, enter4);

    }

    private static int[] getExitPort(char[][] board, int[] enter) {
        List<int[]> res = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(enter);
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[enter[0]][enter[1]] = true;

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (!(cur[0] == enter[0] && cur[1] == enter[1]) && (cur[0] == 0 || cur[0] == board.length-1 || cur[1] == 0 || cur[1] == board[0].length-1) && board[cur[0]][cur[1]] == '0') {
                    return cur;
                }
                for (int[] dir : dirs) {
                    int newRow = dir[0] + cur[0];
                    int newCol = dir[1] + cur[1];

                    if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && !visited[newRow][newCol] && board[newRow][newCol] == '0') {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
}
