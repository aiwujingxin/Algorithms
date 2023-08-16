package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 20:45
 */
public class LeetCode1014_dp_1d {

    //https://leetcode.com/problems/best-sightseeing-pair/discuss/2441083/Java-or-2-methods-or-Explained
    public int maxScoreSightseeingPair(int[] values) {
        var maxScore = 0;
        var n = values.length;
        var dp = new int[n];
        dp[0] = values[0];
        for (var i = 1; i < n; i++) {
            maxScore = Math.max(maxScore, dp[i - 1] + values[i] - i);
            dp[i] = Math.max(dp[i - 1], values[i] + i);
        }
        return maxScore;
    }
}
