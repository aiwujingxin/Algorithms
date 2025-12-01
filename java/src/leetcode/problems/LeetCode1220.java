package leetcode.problems;

import knowledge.mathematics.impl.MathUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 11/16/25 15:21
 */
public class LeetCode1220 {

    Integer[][] memo;
    int n;
    int mod = 1_000_000_007;
    HashMap<Integer, List<Integer>> graph;

    public int countVowelPermutation(int n) {
        this.n = n;
        graph = new HashMap<>();
        graph.put(1, List.of(2));
        graph.put(2, List.of(1, 3));
        graph.put(3, List.of(1, 2, 4, 5));
        graph.put(4, List.of(3, 5));
        graph.put(5, List.of(1));
        memo = new Integer[n + 1][6];
        int cnt = 0;
        for (int i = 1; i <= 5; i++) {
            cnt = (cnt + dfs(1, i)) % mod;
        }
        return cnt;
    }

    public int dfs(int i, int c) {
        if (i == n) {
            return 1;
        }
        if (memo[i][c] != null) return memo[i][c];
        int cnt = 0;
        for (int ch : graph.get(c)) {
            cnt = (dfs(i + 1, ch) + cnt) % mod;
        }
        memo[i][c] = cnt;
        return cnt;
    }

    class Solution {
        int mod = (int) 1e9 + 7;

        public int countVowelPermutation(int n) {
            long[][] mat = new long[][]{
                    {0, 1, 0, 0, 0},
                    {1, 0, 1, 0, 0},
                    {1, 1, 0, 1, 1},
                    {0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0}
            };
            long[][] ans = MathUtil.matPow(mat, n - 1, mod);
            long sum = 0;
            // 遍歷整個 ans 矩陣，將所有元素相加
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    sum = (sum + ans[i][j]) % mod;
                }
            }
            return (int) (sum % mod);
        }
    }
}
