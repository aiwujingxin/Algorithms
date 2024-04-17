package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 18:49
 */
public class LeetCode887 {

    Map<Integer, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dfs(k, n);
    }

    public int dfs(int k, int n) {
        if (memo.containsKey(n * 100 + k)) {
            return memo.get(n * 100 + k);
        }
        if (n == 0) {
            memo.put(k, 0);
            return 0;
        }
        if (k == 1) {
            memo.put(n * 100 + k, n);
            return n;
        }
        int ans;
        int lo = 1, hi = n;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            int t1 = dfs(k - 1, mid - 1);
            int t2 = dfs(k, n - mid);
            if (t1 < t2) {
                lo = mid;
            } else if (t1 > t2) {
                hi = mid;
            } else {
                lo = hi = mid;
            }
        }
        ans = 1 + Math.min(Math.max(dfs(k - 1, lo - 1), dfs(k, n - lo)), Math.max(dfs(k - 1, hi - 1), dfs(k, n - hi)));
        memo.put(n * 100 + k, ans);
        return ans;
    }
}
