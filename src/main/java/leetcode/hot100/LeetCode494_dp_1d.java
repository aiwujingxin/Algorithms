package leetcode.hot100;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 19:32
 */
public class LeetCode494_dp_1d {

    //https://leetcode.com/problems/target-sum/discuss/2479879/Java-or-subset-or-dp

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || Math.abs(target) > Math.abs(sum)) {
            return 0;
        }
        int targetSum = (sum + target) / 2;
        int[] memo = new int[targetSum + 1];
        memo[0] = 1;
        for (int num : nums) {
            for (int j = targetSum; j >= 0; j--) {
                if (num <= j) {
                    memo[j] = memo[j] + memo[j - num];
                }
            }
        }
        return memo[targetSum];
    }
}
