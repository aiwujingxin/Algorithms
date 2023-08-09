package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/29 11:57
 */
public class LeetCode1382 {

    ArrayList<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        travesal(root);
        return toTree(0, list.size() - 1);
    }

    //将有序树转成有序数组
    private void travesal(TreeNode root) {
        if (root == null) return;
        travesal(root.left);
        list.add(root.val);
        travesal(root.right);
    }

    //将有序数组转换成平衡二叉树
    private TreeNode toTree(int left, int right) {
        if (left > right) return null;
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(list.get(mid));
        root.left = toTree(left, mid - 1);
        root.right = toTree(mid + 1, right);
        return root;
    }
}
