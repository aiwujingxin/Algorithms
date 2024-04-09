package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 11:30
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[right], height[left]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
