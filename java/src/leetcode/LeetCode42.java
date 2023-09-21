package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 23:30
 * @see LeetCode84
 * @see LeetCode85_v2
 */
public class LeetCode42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int[] left = new int[height.length];
        int leftMax = height[0];
        left[0] = leftMax;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            left[i] = leftMax;
        }

        int[] right = new int[height.length];
        int rightMax = height[height.length - 1];
        right[0] = rightMax;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            }
            right[i] = rightMax;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
