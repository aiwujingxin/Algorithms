package codeTop.pdd;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2022-02-16 5:04 PM
 */
public class LeetCode402 {

    public static void main(String[] args) {
        System.out.println(new LeetCode402().removeKdigits("", 9));
    }

    public String removeKdigits(String num, int k) {

        if (num == null || num.length() == 0) {
            return "";
        }

        if (num.length() <= k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            //只能移除
            while (!stack.empty() && k > 0 && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        //fix 剔除满k个
        for (int i = 0; i < k; ++i) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        //fix trim
        sb.reverse().toString().trim();
        //过滤掉开头的0
        int index = 0;
        while (index < sb.length()) {
            if (sb.charAt(index) == '0') {
                index++;
            } else {
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = index; i < sb.length(); i++) {
            res.append(sb.charAt(i));
        }

        if (res.length() == 0) {
            //fix
            return "0";
        }

        return res.toString();
    }

}
