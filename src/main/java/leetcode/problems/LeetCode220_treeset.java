package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/17 21:01
 */
public class LeetCode220_treeset {

    TreeNode root;

    private static void delete(TreeNode node, TreeNode prev, TreeNode child) {
        if (node == prev.left) {
            prev.left = child;
        } else {
            prev.right = child;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        root = new TreeNode(nums[0]);
        if (indexDiff == nums.length) {
            indexDiff--;
        }
        for (int i = 1; i <= indexDiff; i++) {
            if (addAndCheck(nums[i], valueDiff)) {
                return true;
            }
        }
        for (int i = 0; i < nums.length - indexDiff - 1; i++) {
            if (nums[i] == nums[i + indexDiff + 1]) {
                continue;
            }
            deleteVal(nums[i]);
            if (addAndCheck(nums[i + indexDiff + 1], valueDiff)) {
                return true;
            }
        }
        return false;
    }

    private boolean addAndCheck(int val, int diff) {
        TreeNode node = root, parent = null;
        while (node != null) {
            if (Math.abs(node.val - val) <= diff) {
                return true;
            }
            parent = node;
            node = val < node.val ? node.left : node.right;
        }
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
        return false;
    }

    private void deleteVal(int key) {
        TreeNode node = root, prev = null;
        while (node.val != key) {
            prev = node;
            node = key < node.val ? node.left : node.right;
        }

        if (node.left == null || node.right == null) {
            TreeNode childOrNull = node.left == null ? node.right : node.left;
            if (prev != null) {
                delete(node, prev, childOrNull);
            } else {
                root = childOrNull;
            }
        } else {
            TreeNode rightLeftmost = node.right;
            prev = node;
            while (rightLeftmost.left != null) {
                prev = rightLeftmost;
                rightLeftmost = rightLeftmost.left;
            }
            node.val = rightLeftmost.val;
            delete(rightLeftmost, prev, rightLeftmost.right);
        }
    }
}
