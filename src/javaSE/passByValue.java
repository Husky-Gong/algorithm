package javaSE;

public class passByValue {
    public static void main(String[] args) {
        int sum = 0;
        dfs(sum, 0);
        System.out.println(sum);
    }

    private static void dfs(int sum, int level) {
        if (level == 6) {
            return;
        }

        sum++;
        level++;
    }
}
