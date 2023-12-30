package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 15:33
 */
public class LeetCode224 {

    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        return dfs(queue);
    }

    private int dfs(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        char perSign = '+';
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            // 遇到左括号开始递归计算 num
            if (c == '(') {
                num = dfs(queue);
            }
            if ((!Character.isDigit(c) && c != ' ') || queue.isEmpty()) {
                switch (perSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                num = 0;
                perSign = c;
            }
            // 遇到右括号返回递归结果
            if (c == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
