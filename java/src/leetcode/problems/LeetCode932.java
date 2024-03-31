package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/30 17:51
 */
public class LeetCode932 {

    Map<Integer, int[]> memo;

    public int[] beautifulArray(int N) {
        memo = new HashMap<>();
        return divide(N);
    }

    public int[] divide(int N) {
        if (memo.containsKey(N)) {
            return memo.get(N);
        }
        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
            memo.put(N, ans);
            return ans;
        }
        int t = 0;
        for (int x : divide((N + 1) / 2)) {
            ans[t++] = 2 * x - 1;
        }
        for (int x : divide(N / 2)) {
            ans[t++] = 2 * x;
        }
        memo.put(N, ans);
        return ans;
    }
}
