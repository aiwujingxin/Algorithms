package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-12-03 10:50 下午
 */
public class LeetCode224 {

    public static void main(String[] args) {
        System.out.println(new LeetCode224().calculate("12*(8/(2*4))/2*(((8/4+7)/9)+3/3+2*2*2)"));
        System.out.println(new LeetCode224().calculate("6*6*6*6*6/36/216"));
        System.out.println(new LeetCode224().calculate("1*2*3*4*5"));
        System.out.println(new LeetCode224().calculate("5*7/15*3"));
    }

    public int calculate(String s) {
        Queue<Character> s1 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            s1.offer(s.charAt(i));
        }
        return helper(s1);
    }

    //https://leetcode-cn.com/problems/basic-calculator/solution/jia-jian-cheng-chu-gua-hao-yun-suan-by-w-ldll/
    public int helper(Queue<Character> s) {
        Stack<Integer> number = new Stack<>();
        char c;
        int n = 0;
        char sign = '+';
        while (!s.isEmpty()) {
            c = s.poll();
            if (Character.isDigit(c)) {
                n = 10 * n + c - '0';
            }
            if (c == '(') {
                n = helper(s);
            }
            if ((!Character.isDigit(c) && c != ' ') || s.isEmpty()) {
                int pre;
                switch (sign) {
                    case '+':
                        number.push(n);
                        break;
                    case '-':
                        number.push(-n);
                        break;
                    case '*':
                        pre = number.pop();
                        pre = pre * n;
                        number.push(pre);
                        break;
                    case '/':
                        pre = number.pop();
                        number.push(pre / n);
                    default:
                        break;

                }
                sign = c;
                n = 0;
            }
            if (c == ')') {
                return sum(number);
            }
        }
        return sum(number);
    }

    private int sum(Stack<Integer> number) {
        int res = 0;
        while (!number.isEmpty()) {
            res += number.pop();
        }
        return res;
    }
}
