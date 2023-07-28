package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 13:59
 */
public class LeetCode120_dp_1d {


    //https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle

    public int minimumTotal(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        int[] dp = new int[rowNum];
        for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
            dp[i] = triangle.get(rowNum - 1).get(i);
        }
        // for each layer
        for (int row = rowNum - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }
}
