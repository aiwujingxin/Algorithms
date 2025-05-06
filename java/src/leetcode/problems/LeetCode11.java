package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 11:30
 */
public class LeetCode11 {

    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1, max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(h[l], h[r]));
            if (h[l] < h[r]) l++;
            else r--;
        }
        return max;
    }
}
