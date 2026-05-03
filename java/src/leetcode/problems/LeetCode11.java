package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 11:30
 */
public class LeetCode11 {

    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1, max = 0;
        while (l < r) {
            int area = (r - l) * Math.min(h[l], h[r]);
            if (area > max) max = area;
            if (h[l] < h[r]) l++;
            else r--;
        }
        return max;
    }

    class Solution_OPT {

        public int maxArea(int[] height) {
            int l = 0;
            int r = height.length - 1;
            int max = 0;
            while (l < r) {
                int h = Math.min(height[l], height[r]);
                int area = (r - l) * h;
                if (area > max) max = area;
                while (l < r && height[l] <= h) l++;
                while (l < r && height[r] <= h) r--;
            }
            return max;
        }
    }
}
