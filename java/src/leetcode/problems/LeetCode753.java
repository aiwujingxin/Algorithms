package leetcode.problems;


import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 20:39
 * @description 欧拉回路 定义点和边
 */
public class LeetCode753 {
    Set<Integer> seen = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    int highest;
    int k;

    public String crackSafe(int n, int k) {
        highest = (int) Math.pow(10, n - 1);
        this.k = k;
        dfs(0);
        for (int i = 0; i < n - 1; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    public void dfs(int u) {
        for (int i = 0; i < k; ++i) {
            int v = u * 10 + i;
            if (!seen.contains(v)) {
                seen.add(v);
                dfs(v % highest);
                sb.append(i);
            }
        }
    }
}
