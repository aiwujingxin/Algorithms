package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-12 2:02 上午
 */
public class LeetCode1014 {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max = values[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, values[i] - i + max);
            max = Math.max(values[i] + i, max);
        }
        return res;
    }
}
