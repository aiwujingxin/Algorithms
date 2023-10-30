package leetcode.problems;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 17:13
 */
public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[triangle.get(n - 1).size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> cur = triangle.get(i);
            for (int j = cur.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + cur.get(j);
                } else if (j == cur.size() - 1) {
                    dp[j] = dp[j - 1] + cur.get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + cur.get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
