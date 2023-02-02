package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 17:01
 */
public class LeetCode740 {

    //nums
    // 2,2,3,3,3,4
    //arr
    // 0 0 4 9 4


    public int deleteAndEarn(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] temp = new int[10001];
        for (int num : nums) {
            temp[num] += num;
        }

        int[] dp = new int[10001];

        dp[0] = temp[0];
        dp[1] = temp[1];

        for (int i = 2; i < temp.length; i++) {
            dp[i] = Math.max(temp[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

}
