package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-11-21 9:10 下午
 */
public class Offer33 {

    public static void main(String[] args) {
        System.out.println(new Offer33().verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

    public boolean verifyPostorderV2(int[] postorder) {
        // 单调栈使用，单调递增的单调栈
        Deque<Integer> stack = new LinkedList<>();
        int pervElem = Integer.MAX_VALUE;
        // 逆向遍历，就是翻转的先序遍历
        for (int i = postorder.length - 1; i >= 0; i--) {
            // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (postorder[i] > pervElem) {
                return false;
            }
            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                pervElem = stack.pop();
            }
            // 这个新元素入栈
            stack.push(postorder[i]);
        }
        return true;
    }
}
