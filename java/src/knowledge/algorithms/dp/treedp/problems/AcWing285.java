package knowledge.algorithms.dp.treedp.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 16:41
 * @description 没有上司的舞会
 * <a href="https://www.acwing.com/problem/content/287/"></a>
 */
public class AcWing285 {

    static ArrayList<Integer>[] son;
    static int[][] dp;
    static int[] v, h;

    public static void dfs(int x) {
        dp[x][0] = 0;
        dp[x][1] = h[x];

        for (int i = 0; i < son[x].size(); i++) {
            int y = son[x].get(i);
            dfs(y);
            dp[x][0] += Math.max(dp[y][0], dp[y][1]);
            dp[x][1] += dp[y][0];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        son = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        v = new int[n + 1];
        h = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            h[i] = scanner.nextInt();
            son[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            v[x] = 1;
            son[y].add(x);
        }

        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (v[i] == 0) {
                root = i;
                break;
            }
        }

        dfs(root);
        System.out.println(Math.max(dp[root][0], dp[root][1]));
    }
}
