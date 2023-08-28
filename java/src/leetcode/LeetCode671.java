package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:31
 */
public class LeetCode671 {

    List<Integer> list = new ArrayList<>();

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        inorder(root);
        if (list == null || list.size() < 2) {
            return -1;
        }
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i - 1).equals(list.get(i))) {
                return list.get(i);
            }
        }
        return -1;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
    }
}
