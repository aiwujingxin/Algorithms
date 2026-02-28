package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 18:11
 */
public class LeetCode42 {

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lx = 0, rx = 0;
        int ans = 0;
        while (l < r) {
            lx = Math.max(lx, height[l]);
            rx = Math.max(rx, height[r]);
            if (lx < rx) {
                ans += lx - height[l];
                l++;
            } else {
                ans += rx - height[r];
                r--;
            }
        }
        return ans;
    }

    class Solution_DP {

        public int trap(int[] h) {
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

    class Solution_Stack {

        public int trap(int[] height) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = height.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) break;
                    int left = stack.peek();
                    int w = i - left - 1;
                    int h = Math.min(height[i], height[left]) - height[top];
                    ans += w * h;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
