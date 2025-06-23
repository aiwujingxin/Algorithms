package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 19:38
 */
public class LeetCode45 {

    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int nextMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]); // nextMax是每到一个点都需要算的
            if (i == end) {
                step++;// 当到 i 到 end 时，后继乏力，则需要跳跃
                end = nextMax;  // 但max可以放宽到的由之前得到的nextMax，到nextMax之前都不需要跳跃
            }
        }
        return step;
    }
}
