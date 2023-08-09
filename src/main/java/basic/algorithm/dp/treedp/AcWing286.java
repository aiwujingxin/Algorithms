package basic.algorithm.dp.treedp;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 16:46
 * <a href="https://www.acwing.com/problem/content/description/288/"></a>
 */
public class AcWing286 {

    static int[][] f;
    static ArrayList<Integer>[] son;
    static int[] w;
    static int n, m;

    public static void dfs(int x) {
        f[x][0] = 0;

        for (int i = 0; i < son[x].size(); i++) {
            int y = son[x].get(i);
            dfs(y);
            for (int t = m; t >= 0; t--) {
                for (int j = t; j >= 0; j--) {
                    if (t - j >= 0) {
                        f[x][t] = Math.max(f[x][t], f[x][t - j] + f[y][j]);
                    }
                }
            }
        }

        if (x != 0) {
            for (int t = m; t > 0; t--) {
                f[x][t] = f[x][t - 1] + w[x];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        f = new int[n + 1][m + 1];
        son = new ArrayList[n + 1];
        w = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            son[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            son[x].add(i);
            w[i] = y;
        }

        dfs(0);
        System.out.println(f[0][m]);
    }
}
