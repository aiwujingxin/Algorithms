package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2022-02-14 10:53 PM
 */
public class LeetCode772 {


    public int calculate(String s) {
        return (int) cal(s);
    }

    public double cal(String expr) {
        Queue<Character> exprQueue = new LinkedList<>();
        for (int i = 0; i < expr.length(); i++) {
            exprQueue.offer(expr.charAt(i));
        }
        return helper(exprQueue);
    }

    public int helper(Queue<Character> exprQueue) {

        Stack<Integer> numStack = new Stack<>();
        char c;
        int n = 0;
        char sign = '+';
        while (!exprQueue.isEmpty()) {
            c = exprQueue.poll();
            if (Character.isDigit(c)) {
                n = 10 * n + c - '0';
            }
            if (c == '(') {
                n = helper(exprQueue);
            }
            if ((!Character.isDigit(c) && c != ' ') || exprQueue.isEmpty()) {
                int pre;
                switch (sign) {
                    case '+':
                        numStack.push(n);
                        break;
                    case '-':
                        numStack.push(-n);
                        break;
                    case '*':
                        pre = numStack.pop();
                        pre = pre * n;
                        numStack.push(pre);
                        break;
                    case '/':
                        pre = numStack.pop();
                        numStack.push(pre / n);
                    default:
                        break;

                }
                sign = c;
                n = 0;
            }
            if (c == ')') {
                return sum(numStack);
            }
        }
        return sum(numStack);

    }

    private int sum(Stack<Integer> numStack) {
        int res = 0;
        while (!numStack.isEmpty()) {
            res += numStack.pop();
        }
        return res;
    }
}
