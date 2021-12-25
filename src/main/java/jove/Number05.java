package jove;

/**
 * @author jingxinwu
 * @date 2021-12-23 7:07 PM
 */

import java.util.Stack;

/**
 * 第五题: 逆置栈中元素
 * * 有两个相同的栈，一个里面放着自大到小排列的数，栈顶的数最小，另一个栈是空的.
 * * 不允许利用其它的数据结构，只能利用这两个栈，要求把第一个栈里的数字反过来，从
 * * 小到大排列，结果还放在原来的那个栈里面。
 * 1
 * 2
 * 3
 * 5
 * 6
 * 7
 */

public class Number05 {

    public Stack<Integer> sort(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (stack1.empty() || stack2.empty()) {
            return stack1;
        }
        for (int i = 0; i < stack1.size(); i++) {
            Integer temp = stack1.pop();
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(temp);
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1;
    }
}
