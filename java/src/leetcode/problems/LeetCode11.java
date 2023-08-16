package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-06-14 1:14 下午
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int size = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(size, max);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
