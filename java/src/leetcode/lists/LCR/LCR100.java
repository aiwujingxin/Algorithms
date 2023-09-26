package leetcode.lists.LCR;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 11:05
 */

public class LCR100 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int index = 1; index < triangle.size(); index++) {
            List<Integer> level = triangle.get(index);
            for (int j = level.size() - 1; j >= 0; j--) {
                if (j == level.size() - 1) {
                    dp[j] = dp[j - 1];
                } else if (j == 0) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]);
                }
                dp[j] += level.get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j : dp) {
            min = Math.min(min, j);
        }
        return min;
    }
}
