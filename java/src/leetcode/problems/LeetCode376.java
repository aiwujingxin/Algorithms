package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 11:24
 * @description 双状态来回更新 空间压缩了
 */
public class LeetCode376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }
}
