package common;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-07-04 5:08 下午
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
