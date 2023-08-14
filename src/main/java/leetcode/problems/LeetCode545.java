package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 13:16
 * <a href="https://www.youtube.com/watch?v=dARie9XFXWo"></a>
 */
public class LeetCode545 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }

        res.add(root.val);

        getLeft(root.left);
        getBottom(root);
        getRight(root.right);

        return res;
    }

    private void getLeft(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        res.add(root.val);

        if (root.left != null) {
            getLeft(root.left);
        } else {
            getLeft(root.right);
        }
    }

    private void getBottom(TreeNode root) {
        if (root == null) {
            return;
        }
        getBottom(root.left);
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        getBottom(root.right);
    }

    private void getRight(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            getRight(root.right);
        } else {
            getRight(root.left);
        }
        res.add(root.val);
    }
}
