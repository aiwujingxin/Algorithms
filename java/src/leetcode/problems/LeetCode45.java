package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 19:38
 */
public class LeetCode45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        int step = 0;
        int max = 0;
        int nextMax = 0;
        for (int i = 0; i < n - 1; i++) {
            // nextMax是每到一个点都需要算的
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == max) {
                // 当到 i 到 max 时，后继乏力，则需要跳跃
                step++;
                // 但max可以放宽到的由之前得到的nextMax，到nextMax之前都不需要跳跃
                max = nextMax;
            }
        }
        return step;
    }
}
