package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 00:08
 */
public class LeetCode1504 {

    public int numSubmat(int[][] array) {
        int res = 0;
        int[] height = new int[array[0].length];
        for (int[] ints : array) {
            for (int j = 0; j < height.length; j++) {
                height[j] = ints[j] == 0 ? 0 : height[j] + 1;
            }
            res += sum(height);
        }
        return res;
    }

    public int sum(int[] height) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int index = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int len = right - left - 1;
                int H = height[index] - Math.max(left == -1 ? 0 : height[left], height[right]);
                num += ((len * (len + 1)) / 2) * H;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int right = height.length - 1;
            int len = right - left;
            int H = height[index] - Math.max(left == -1 ? 0 : height[left], 0);
            num += ((len * (len + 1)) / 2) * H;
        }
        return num;
    }
}
