package leetcode;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2022-02-26 3:11 PM
 */
public class LeetCode739_v1 {


    public int[] dailyTemperatures(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int[] answer = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = array.length - 1; i >= 0; i--) {
            // stack中存放的是 数组的index
            while (!stack.empty() && array[i] >= array[stack.peek()]) {
                stack.pop();
            }
            answer[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }
}
