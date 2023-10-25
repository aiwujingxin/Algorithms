package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/25 22:48
 */
public class LeetCode1006 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1006().clumsy(2));
    }

    public int clumsy(int n) {
        if (n == 1) {
            return 1;
        }
        char[] signs = new char[]{'*', '/', '+', '-'};
        int res = 0;
        Stack<Double> stack = new Stack<>();
        stack.add((double) n);
        for (int num = n - 1; num >= 1; num--) {
            char sign = signs[(n - num - 1) % 4];
            switch (sign) {
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
                case '+':
                    stack.push((double) num);
                    break;
                case '-':
                    stack.push(-(double) num);
                    break;
                default:
                    break;
            }
        }
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}
