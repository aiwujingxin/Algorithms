package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 16:38
 * @see LeetCode1798
 */
public class LeetCode330 {

    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long reach = 0;
        int i = 0;
        while (reach < n) {
            if (i < nums.length && nums[i] <= reach + 1) {
                reach += nums[i];
                i++;
            } else {
                reach += reach + 1;  // 补充 reach + 1，覆盖范围翻倍加一
                patches++;
            }
        }
        return patches;
    }
}
