package leetcode.problems;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/12 23:22
 */
public class LeetCode106_v2 {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int[] postIndex = new int[]{postorder.length - 1};
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return arrayToTree(postorder, 0, postorder.length - 1, postIndex);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right, int[] postIndex) {
        if (left > right) {
            return null;
        }
        int value = postorder[postIndex[0]];
        postIndex[0] = postIndex[0] - 1;
        TreeNode root = new TreeNode(value);
        int index = map.get(value);
        root.right = arrayToTree(postorder, index + 1, right, postIndex);
        root.left = arrayToTree(postorder, left, index - 1, postIndex);
        return root;
    }
}
