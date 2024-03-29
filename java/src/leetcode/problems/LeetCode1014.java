package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-12 2:02 上午
 */
public class LeetCode1014 {

    public int maxScoreSightseeingPair(int[] values) {

        if (values == null || values.length <= 1) {
            return 0;
        }
        int[] dp1 = new int[values.length];
        dp1[0] = values[0];
        for (int i = 1; i < values.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], values[i] + i);
        }

        int[] dp2 = new int[values.length];
        for (int j = 1; j < values.length; j++) {
            dp2[j] = values[j] - j;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, dp2[i] + dp1[i - 1]);
        }
        return res;
    }
}
