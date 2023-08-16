package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-13 1:07 AM
 */
public class LeetCode416_dp {
    //https://leetcode.com/problems/partition-equal-subset-sum/solutions/1624101/java-memoization-to-optimized-dp-detailed-explanation/

    public static void main(String[] args) {
        System.out.println(new LeetCode416_dp().canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target + 1];

        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                //考虑当前数
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    //不考虑当前值
                    dp[i][j] = dp[i - 1][j];
                }
            }

            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }

}
