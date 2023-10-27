package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 17:15
 */
public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int index = (start + end) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = sortedArrayToBST(nums, start, index - 1);
        root.right = sortedArrayToBST(nums, index + 1, end);
        return root;
    }
}


