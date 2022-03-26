package codeTop.mid;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-25 8:08 PM
 */
public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        binaryTreePathsRec(root, new StringBuilder(), result);
        return result;
    }

    private void binaryTreePathsRec(TreeNode node, StringBuilder currentPath, List<String> output) {

        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            output.add(String.valueOf(currentPath) + node.val);
            return;
        }
        binaryTreePathsRec(node.left, new StringBuilder(currentPath).append(node.val).append("->"), output);
        binaryTreePathsRec(node.right, new StringBuilder(currentPath).append(node.val).append("->"), output);
    }
}
