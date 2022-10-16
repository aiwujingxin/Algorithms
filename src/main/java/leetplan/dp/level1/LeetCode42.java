package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 19:34
 */
public class LeetCode42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left_max = height[0];
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left_max = Math.max(left_max, height[i]);
            left[i] = left_max;
        }

        int right_max = height[height.length - 1];
        int[] right = new int[height.length];
        right[right.length - 1] = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            right_max = Math.max(right_max, height[i]);
            right[i] = right_max;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            max += Math.min(right[i], left[i]) - height[i];
        }

        return max;
    }
}
