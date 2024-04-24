package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 18:11
 */
public class LeetCode42 {

    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public int trap_dp(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] left = new int[n];
        int leftMax = height[0];
        for (int i = 0; i < n; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            left[i] = leftMax;
        }
        int[] right = new int[n];
        int rightMax = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            }
            right[i] = rightMax;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
