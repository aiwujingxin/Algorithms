package leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 21:44
 */
public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                if (index < n - 1)
                    res[index] = arr[i];
            }
            stack.push(i);
        }
        return res;
    }
}
