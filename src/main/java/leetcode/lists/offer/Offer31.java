package leetcode.lists.offer;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-11-21 8:25 下午
 */
public class Offer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }

}
