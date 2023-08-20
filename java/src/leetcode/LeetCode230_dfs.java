package leetcode;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @author jingxinwu
 * @date 2021-08-25 1:29 上午
 */
public class LeetCode230_dfs {

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k - 1);
    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
