package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/14 22:13
 */
public class LeetCode1186 {

    public int maximumSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][2];
        //不删除
        dp[0][0] = arr[0];
        //删除
        dp[0][1] = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0) + arr[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            max = Math.max(Math.max(max, dp[i][0]), dp[i][1]);
        }
        return max;
    }
}
