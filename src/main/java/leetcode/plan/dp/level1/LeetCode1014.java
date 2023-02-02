package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 20:09
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
        dp2[0] = values[0];
        for (int j = 1; j < values.length; j++) {
            //why
            //https://leetcode.cn/problems/best-sightseeing-pair/solution/zui-jia-guan-guang-zu-he-by-leetcode-solution/
            //我们考虑从前往后遍历 j 来统计答案，对于每个观光景点 j 而言，我们需要遍历 [0,j-1]的观光景点 i 来计算组成观光组合得分的最大值来作为第 j 个观光景点的值
            dp2[j] = values[j] - j;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, dp2[i] + dp1[i - 1]);
        }
        return res;
    }
}
