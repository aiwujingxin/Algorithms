package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/22 21:34
 * @see LeetCode453
 */
public class LeetCode462 {
    //https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/solutions/785845/czhong-wei-shu-jian-dan-zheng-ming-by-ke-a2v9/

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ret = 0, x = nums[n / 2];
        for (int num : nums) {
            ret += Math.abs(num - x);
        }
        return ret;
    }
}
