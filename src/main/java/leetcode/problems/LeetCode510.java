package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/14 11:15
 */
public class LeetCode510 {

    //https://leetcode.cn/problems/inorder-successor-in-bst-ii/solution/hong-hei-shu-shi-zen-yao-zhao-hou-ji-jie-dian-de-z/

    public Node inorderSuccessor(Node x) {
        Node node = x.right;
        if (node != null) {
            // 存在右子树，那么x的后继就是node的最左节点
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        // 不存在右子树，那么后继就是x所在子树的第一个左孩子的父节点
        node = x;
        Node parent = node.parent;
        while (parent != null && parent.right == node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }
}
