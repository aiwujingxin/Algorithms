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
            if (stack.empty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i]) {
                int index = stack.pop();
                res = Math.max(res, i - index);
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
            int index = leftBound(minArr, nums[i]);
            if (minArr[index] <= nums[i]) {
                res = Math.max(res, i - index);
            }
        }
        return res;
    }

    public int leftBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
