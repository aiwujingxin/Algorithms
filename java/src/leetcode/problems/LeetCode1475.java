package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/10 21:55
 */
public class LeetCode1475 {

    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) {
            return new int[]{};
        }
        int n = prices.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prices[i];
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                res[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        return res;
    }
}
