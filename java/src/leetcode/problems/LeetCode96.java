package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:32
 */
public class LeetCode96 {

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public int numTrees_dfs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = numTrees_dfs(i);
            int right = numTrees_dfs(n - i - 1);
            res += left * right;
        }
        return res;
    }
}
