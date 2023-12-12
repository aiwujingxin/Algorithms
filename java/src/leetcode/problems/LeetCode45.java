package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 10:52
 */
public class LeetCode45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int res = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                res++;
            }
        }
        return res;
    }
}
