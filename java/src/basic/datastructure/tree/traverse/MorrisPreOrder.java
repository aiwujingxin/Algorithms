package basic.datastructure.tree.traverse;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 21:46
 * @see <a href="https://zhuanlan.zhihu.com/p/101321696"></a>
 */
public class MorrisPreOrder {

    public List<Integer> Iteration(TreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();

        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            // cur表示当前节点，mostRight表示cur的左孩子的最右节点
            mostRight = cur.left;
            if (mostRight != null) {
                // cur有左孩子，找到cur左子树最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight的右孩子指向空，让其指向cur，cur向左移动
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    // mostRight的右孩子指向cur，让其指向空，cur向右移动
                    mostRight.right = null;
                }
            } else {
                list.add(cur.val);
            }
            cur = cur.right;
        }
        return list;
    }
}