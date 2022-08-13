package company.walmartLab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'c', 'c', 't', 'n', 'a', 'x'},
                {'c', 'c', 'a', 't', 'n', 't'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'n', 'i', 'i', 'p', 'p'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'s', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'o', 'k', 'i'}};
        List<int[]> result = new ArrayList<>();
        result = getWordPath(grid, "catnip");
    }
    static boolean[][] visited;
    static int[][] dirs;
    static List<int[]> res;
    private static List<int[]> getWordPath(char[][] grid, String word) {
        res = new ArrayList<>();
        visited = new boolean[grid.length][grid[0].length];
        dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (word.charAt(0) == grid[i][j]) {
                    List<int[]> tempList = new ArrayList<>();
                    dfs(grid, word, tempList, i, j, 0);
                }
            }
        }

        return res;
    }

    private static void dfs(char[][] grid, String word, List<int[]> tempList, int i, int j, int index) {
        // 将该点加入到结果中，并且检查word是否找到
        tempList.add(new int[]{i, j});
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (index == word.length() - 1) {
                for (int k = 0; k < tempList.size(); k++) {
                    res.add(tempList.get(k));
                }
                return;
            }
            if (newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length && grid[newi][newj] == word.charAt(index+1) && !visited[newi][newj]) {
                dfs(grid, word, tempList, newi, newj, index+1);
            }
        }

        tempList.remove(tempList.size() - 1);
        visited[i][j] = false;

    }
}
