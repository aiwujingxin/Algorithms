package leetcode.problems;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2022-02-14 10:53 PM
 */
public class LeetCode772 {

    public static void main(String[] args) {
        System.out.println(new LeetCode772().calculate("12*(8/(2*4))/2*(((8/4+7)/9)+3/3+2*2*2)"));
        System.out.println(new LeetCode772().calculate("6*6*6*6*6/36/216"));
        System.out.println(new LeetCode772().calculate("1*2*3*4*5"));
        System.out.println(new LeetCode772().calculate("5*7/15*3"));
    }

    public int calculate(String s) {
        return dfs(s, 0)[0];
    }

    public int[] dfs(String s, int index) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            }
            if (c == '(') {
                int[] res = dfs(s, i + 1);
                num = res[0];
                i = res[1];
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        pre = pre * num;
                        stack.push(pre);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                    default:
                        break;

                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                return new int[]{sum(stack), i};
            }
        }
        return new int[]{sum(stack), s.length()};
    }

    private int sum(Stack<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
