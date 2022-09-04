package leetCode.problems;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2022-01-23 11:14 PM
 */
public class LeetCode402 {

    public static void main(String[] args) {
        System.out.println(new LeetCode402().removeKdigits("100", 1));
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        for (int i = 0; i < k; ++i) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String st = sb.reverse().toString().trim();
        int i = 0;
        for (; i < st.length(); i++) {
            if (st.charAt(i) != '0') {
                break;
            }
        }
        st = st.substring(i);
        if (st.length() == 0) {
            return "0";
        }
        return st;
    }
}
