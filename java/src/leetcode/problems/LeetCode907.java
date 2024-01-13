package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/13 22:33
 */
public class LeetCode907 {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            leftMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            rightMin[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            long lmin = i - leftMin[i];
            long rmin = rightMin[i] - i;
            ans += (lmin * rmin) * arr[i] % MOD;
        }
        return (int) (ans % MOD);
    }
}
