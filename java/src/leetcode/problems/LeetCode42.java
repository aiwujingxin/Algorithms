package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 18:11
 */
public class LeetCode42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] left = new int[n];
        int lmax = height[0];
        left[0] = lmax;
        for (int i = 1; i < n; i++) {
            if (height[i] > lmax) {
                lmax = height[i];
            }
            left[i] = lmax;
        }
        int[] right = new int[n];
        int rmax = height[n - 1];
        right[n - 1] = rmax;
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > rmax) {
                rmax = height[i];
            }
            right[i] = rmax;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public int trap_twopoint(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;
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
}
