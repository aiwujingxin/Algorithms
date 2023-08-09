package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/10 21:46
 */
public class LeetCode331_stack {

    //https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/solution/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt/

    public static void main(String[] args) {
        System.out.println(new LeetCode331_stack().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        for (String s : preorder.split(",")) {
            while (!stack.isEmpty() && stack.peek().equals("#") && s.equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(s);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
