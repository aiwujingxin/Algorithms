package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:33
 */
public class LeetCode783 {

    List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        inorder(root);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            diff = Math.min(diff, list.get(i + 1) - list.get(i));
        }
        return diff;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
    }
}
