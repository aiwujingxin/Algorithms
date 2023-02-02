package leetcode.lists.hot100;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 14:29
 */
public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return temperatures;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        //    1 2 3  6 4  3 2 1 0 5
        stack.push(temperatures[0]);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int day = stack.pop();
                res[day] = i - day;
            }
            stack.push(i);

        }
        return res;
    }
}
