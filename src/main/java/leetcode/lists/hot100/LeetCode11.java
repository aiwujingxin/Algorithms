package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 23:03
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

            int temp = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(temp, max);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
