package basicKnowledge.datastructure.tree.base.traverse;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:52
 */
public class PostOrderIteration_single_stack_v1 extends PostOrder implements Traverse {


    @Override
    public List<Integer> traverseByIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        // 连续从左路进入，进入到不能进入了，返回一层，从栈里拿出一个元素，下降到它的右边
        // 下降一位就行， 然后继续访问左路
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; // 左节点不断入栈
            } else {
                cur = stack.peek();
                if (cur.right != null && cur.right != pre) { // 不访问节点的条件
                    cur = cur.right; // 下降到右节点
                    stack.push(cur);  // 右节点入栈
                    cur = cur.left; //  // 继续把右节点 的左节点入栈
                } else { // 访问节点的条件: 右节点已经访问完了
                    cur = stack.pop();
                    list.add(cur.val); //直接访问
                    pre = cur; // 这一步是记录上一次访问的节点
                    cur = null; // 此处为了跳过下一次循环的访问左子节点的过程，直接进入栈的弹出阶段，因为但凡在栈中的节点，它们的左子节点都肯定被经过且已放入栈中。
                }
            }
        }
        return list;
    }
}

