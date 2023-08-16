package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 19:54
 */
public class LeetCode42_dp {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        leftmax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }
        rightmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            result += Math.min(leftmax[i], rightmax[i]) - height[i];
        }
        return result;
    }
}
