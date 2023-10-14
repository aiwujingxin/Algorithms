package leetcode.lists.lcr;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 21:15
 */
public class LCR37 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < Math.abs(aster); // aster 是否存在
                if (stack.peek() <= Math.abs(aster)) {  // 栈顶小行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
