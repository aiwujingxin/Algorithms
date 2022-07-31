package LeetCode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/29 00:28
 */
public class LeetCode813 {



    //https://leetcode.com/problems/largest-sum-of-averages/discuss/916679/DFS-greater-DP-Progression-With-Explanation-O(kn2)O(kn)
    public double largestSumOfAverages(int[] A, int K) {
        return solve(A, 0, K, new double[A.length][K + 1]);
    }

    public double solve(int[] nums, int idx, int k, double[][] dp) {
        if (k == 1) {
            double sum = 0;
            for (int i = idx; i < nums.length; i++) {
                sum += nums[i];
            }
            return sum / (nums.length - idx);
        }

        if (dp[idx][k] != 0) {
            return dp[idx][k];
        }

        double max = 0;
        for (int i = idx; i < nums.length; i++) {
            double avg = 0;
            for (int j = idx; j < i + 1; j++) {
                avg += nums[j];
            }
            avg = avg / (i + 1 - idx);
            if (i + 1 < nums.length && k > 1) {
                double v = solve(nums, i + 1, k - 1, dp);
                max = Math.max(max, avg + v);
            }
        }
        return dp[idx][k] = max;
    }
}
