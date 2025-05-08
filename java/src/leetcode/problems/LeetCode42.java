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

    public int trap_dp(int[] h) {
        int n = h.length, res = 0;
        int[] l = new int[n], r = new int[n];
        int lm = 0, rm = 0;
        for (int i = 0; i < n; i++) {
            l[i] = lm = Math.max(lm, h[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            r[i] = rm = Math.max(rm, h[i]);
            res += Math.min(l[i], r[i]) - h[i];
        }
        return res;
    }
}
