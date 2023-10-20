package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 23:30
 * @see LeetCode84
 * @see LeetCode85_v2
 */
public class LeetCode42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] left = new int[height.length];
        int left_max = height[0];
        left[0] = left_max;
        for (int i = 1; i < height.length; i++) {
            if (left_max < height[i]) {
                left_max = height[i];
            }
            left[i] = left_max;
        }
        int[] right = new int[height.length];
        int right_max = height[height.length - 1];
        right[right.length - 1] = right_max;
        for (int i = height.length - 2; i >= 0; i--) {
            if (right_max < height[i]) {
                right_max = height[i];
            }
            right[i] = right_max;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
