package basic.datastructure.string.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/29 19:02
 * @description 中缀转后缀
 */
public class InfixToSuffix {

    public String[] infixToSuffix(String s) {
        if (s == null || s.isEmpty()) {
            return new String[]{};
        }
        s = s.trim();
        s = s.replace(" ", "");
        Stack<Character> stack = new Stack<>();
        // 优先级
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        List<String> list = new ArrayList<>();
        list.add("0");
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                // 结尾的数字
                if (i == s.length() - 1) {
                    list.add(String.valueOf(num));
                }
            }
            if (!Character.isDigit(c)) {
                if (c == '(') {
                    stack.push(c);
                } else {

                    // 加入运算符前的数，避免运算符前不是数字
                    boolean preIsNumber = i > 0 && Character.isDigit(s.charAt(i - 1));
                    if (c == ')') {
                        if (preIsNumber) {
                            list.add(String.valueOf(num));
                            num = 0;
                        }
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            list.add(String.valueOf(stack.pop()));
                        }
                        stack.pop();
                    } else {
                        if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
                            list.add("0");
                        }
                        if (preIsNumber) {
                            list.add(String.valueOf(num));
                            num = 0;
                        }
                        while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
                            list.add(String.valueOf(stack.pop()));
                        }
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(String.valueOf(stack.pop()));
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
