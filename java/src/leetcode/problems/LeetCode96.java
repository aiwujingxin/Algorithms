package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:32
 */
public class LeetCode96 {

    HashMap<Integer, Integer> memo = new HashMap<>();

    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = numTrees(i);
            int right = numTrees(n - i - 1);
            res += left * right;
        }
        memo.put(n, res);
        return res;
    }

    public int numTrees_dp(int n) {
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
}
