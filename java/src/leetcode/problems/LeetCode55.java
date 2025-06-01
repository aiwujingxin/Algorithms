package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 22:32
 */
public class LeetCode55 {

    public boolean canJump(int[] nums) {
        int max = 0; // 当前能够跳到的最远位置
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false; // 如果当前位置 i 已经超出最远可达位置，说明无法到达
            }
            max = Math.max(max, i + nums[i]); // 更新最远可达位置
        }
        return true; // 如果循环顺利结束，说明可以跳到最后一个位置
    }
}
