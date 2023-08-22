package basicKnowledge.algorithm.dynamicProgramming.tree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 16:41
 * <a href="https://www.acwing.com/problem/content/287/"></a>
 */
public class AcWing285 {

    static ArrayList<Integer>[] son;
    static int[][] f;
    static int[] v, h;

    public static void dp(int x) {
        f[x][0] = 0;
        f[x][1] = h[x];

        for (int i = 0; i < son[x].size(); i++) {
            int y = son[x].get(i);
            dp(y);
            f[x][0] += Math.max(f[y][0], f[y][1]);
            f[x][1] += f[y][0];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        son = new ArrayList[n + 1];
        f = new int[n + 1][2];
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

        dp(root);
        System.out.println(Math.max(f[root][0], f[root][1]));
    }
}
