package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 18:11
 */
public class LeetCode42 {

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int lMax = 0, rMax = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            rMax = Math.max(rMax, height[r]);
            lMax = Math.max(lMax, height[l]);
            if (lMax < rMax) {
                ans += lMax - height[l];
                l++;
            } else {
                ans += rMax - height[r];
                r--;
            }
        }
        return ans;
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
