package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-12 2:02 上午
 */
public class LeetCode1014 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1014().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }


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
            dp2[j] = Math.max(dp2[j - 1], values[j] - j);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, dp2[i] + dp1[i - 1]);
        }
        return res;
    }


    //timeout
    public int maxScoreSightseeingPairV2(int[] values) {
        if (values == null || values.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                int temp = values[j] + values[i] + i - j;
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
