package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 23:16
 */
public class LeetCode823 {

    long[] memo;
    Map<Integer, Integer> idx;

    public int numFactoredBinaryTrees(int[] arr) {
        final long MOD = (long) 1e9 + 7;
        int n = arr.length;
        memo = new long[n];
        Arrays.fill(memo, -1);
        idx = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            idx.put(arr[i], i);
        }
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += dfs(i, arr);
        }
        return (int) (ans % MOD);
    }

    private long dfs(int index, int[] arr) {
        if (memo[index] != -1) {
            return memo[index];
        }
        // 递归边界：如果 val 无法分解因子，相当于 return 1
        long res = 1;
        int val = arr[index];
        for (int x : arr) {
            if (val % x == 0 && idx.containsKey(val / x)) {
                res += dfs(idx.get(x), arr) * dfs(idx.get(val / x), arr);
            }
        }
        memo[index] = res;
        return res;
    }
}

