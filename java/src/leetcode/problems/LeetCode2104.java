package leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/31 22:31
 */
public class LeetCode2104 {

    public static void main(String[] args) {
        System.out.println(new LeetCode2104().subArrayRanges(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public long subArrayRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // 左侧最近的比它小的数的下标，minRight 表示右侧最近的比它小的数的下标
        int[] left_min = new int[n];
        int[] left_max = new int[n];
        int[] right_min = new int[n];
        int[] right_max = new int[n];
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack1.empty() && nums[i] < nums[stack1.peek()]) {
                stack1.pop();
            }
            left_min[i] = stack1.empty() ? -1 : stack1.peek();
            stack1.add(i);
            while (!stack2.empty() && nums[i] > nums[stack2.peek()]) {
                stack2.pop();
            }
            left_max[i] = stack2.empty() ? -1 : stack2.peek();
            stack2.add(i);
        }
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack1.empty() && nums[i] <= nums[stack1.peek()]) {
                stack1.pop();
            }
            right_min[i] = stack1.empty() ? n : stack1.peek();
            stack1.add(i);

            while (!stack2.empty() && nums[i] >= nums[stack2.peek()]) {
                stack2.pop();
            }
            right_max[i] = stack2.empty() ? n : stack2.peek();
            stack2.add(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int lmin = i - left_min[i];
            int rmin = right_min[i] - i;


            int lmax = i - left_max[i];
            int rmax = right_max[i] - i;
            res += ((long) lmax * rmax - (long) lmin * rmin) * nums[i];
        }
        return res;
    }
}
