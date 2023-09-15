package leetcode.offer;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 23:40
 */
public class Offer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            //按照压栈序列的顺序执行。
            stack.push(num);
            // 每次入栈后，循环判断 “栈顶元素 === 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        //若 stack 为空，则此弹出序列合法。
        return index == n;
    }
}
