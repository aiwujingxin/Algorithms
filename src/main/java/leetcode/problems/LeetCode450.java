package leetcode.problems;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2022-02-16 7:04 PM
 */
public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        return helper(root, key);
    }

    public TreeNode helper(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = helper(root.left, key);
        } else if (root.val < key) {
            root.right = helper(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            //1 将指向即将被删除的结点的链接保存为 t；
            TreeNode t = root;
            //2 替换
            root = min(t.right);
            //3 将 x 的右链接（原本指向一棵所有结点都大于 x.key 的二叉查找树）指向deleteMin(t.right)，
            //4 也就是在删除后所有结点仍然大于 x.key 的子二叉查找树；
            root.right = deleteMin(t.right);

            //将 x 的左链接（本为空）设为 t.left（其下所有的键都小于被删除的结点和它的后继结点）。
            root.left = t.left;
        }
        return root;
    }

    // 找后继节点
    public TreeNode min(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    //deleteMin
    //不断深入根结点的左子树中直至遇见一个空链接，然后将指向该节点的链接指向该节点的右子树
    public TreeNode deleteMin(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

}
