package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 19:01
 */
public class LeetCode962 {

    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }

    public int maxWidthRamp_bs(int[] nums) {
        int n = nums.length;
        int[] minArr = new int[n];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            }
            minArr[i] = min;
        }
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findL(minArr, nums[i]);
            if (minArr[index] <= nums[i]) {
                res = Math.max(res, i - index);
            }
        }
        return res;
    }

    public int findL(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (a[m] > x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
