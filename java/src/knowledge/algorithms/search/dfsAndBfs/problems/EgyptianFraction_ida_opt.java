package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 5/22/25 00:36
 * @description 埃及分数优化 IDA*
 * <a href="https://www.acwing.com/solution/content/246067/"></a>
 */

public class EgyptianFraction_ida_opt {
    static final int INF = (int) 1e7;
    static int a, b;
    static List<Integer> ans = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    // 最大公约数
    static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    // 深度优先搜索
    static void dfs(int u, long x, long y, int start, int depth, int max_y) {
        long d = gcd(x, y);
        x /= d;
        y /= d;

        if (y > max_y) return;

        if (u == depth) {
            if (x == 0 && (ans.isEmpty() || ans.get(ans.size() - 1) > path.get(path.size() - 1))) {
                ans = new ArrayList<>(path);
            }
            return;
        }

        int l = Math.max(start, (int) ((y + x - 1) / x));
        int r = (int) (y * (depth - u) / x);

        for (int i = l; i <= r; i++) {
            path.add(i);
            dfs(u + 1, i * x - y, i * y, i + 1, depth, max_y);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.close();

        outer:
        for (int depth = 1; ; depth++) {
            for (int max_y = 10000; max_y <= INF; max_y *= 10) {
                dfs(0, a, b, 1, depth, max_y);
                if (!ans.isEmpty()) break outer;
            }
        }

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}

