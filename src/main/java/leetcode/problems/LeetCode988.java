package leetcode.problems;

import common.TreeNode;

import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 12:42
 */
public class LeetCode988 {


    String res = "";
    String temp = "";

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        backtrack(root);
        return res;
    }

    private void backtrack(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            temp = (char) (root.val + 'a') + temp;
            if (Objects.equals(res, "")) {
                res = temp;
                temp = temp.substring(1);
                return;
            }
            if (temp.compareTo(res) < 0) {
                res = temp;
            }
            temp = temp.substring(1);
            return;
        }
        temp = (char) (root.val + 'a') + temp;
        backtrack(root.left);
        backtrack(root.right);
        temp = temp.substring(1);
    }
}
