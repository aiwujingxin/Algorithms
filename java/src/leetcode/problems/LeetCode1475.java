package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/10 21:55
 * @description 尽量得符合模型，该逆向遍历还是得逆向遍历
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
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - prices[stack.peek()];
            stack.push(i);
        }
        return res;
    }
}
