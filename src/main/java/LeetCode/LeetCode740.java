package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-12-06 1:01 上午
 */
public class LeetCode740 {


    public int deleteAndEarn(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] temp = new int[10000];
        for (int num : nums) {
            temp[num] += num;
        }
        // System.out.println(Arrays.toString(temp));

        int[] dp = new int[10000];

        dp[0] = temp[0];
        dp[1] = temp[1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(temp[i] + dp[i - 2],
                    dp[i - 1]);
        }
        // System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
