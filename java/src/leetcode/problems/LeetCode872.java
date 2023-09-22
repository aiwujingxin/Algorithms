package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:35
 */
public class LeetCode872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> treeList1 = new ArrayList<>();
        List<Integer> treeList2 = new ArrayList<>();
        dfs(root1, treeList1);
        dfs(root2, treeList2);
        return treeList1.equals(treeList2);
    }

    void dfs(TreeNode root, List<Integer> treeList) {
        if (root == null) {
            return;
        }
        dfs(root.left, treeList);
        if (root.left == null && root.right == null) {
            treeList.add(root.val);
        }
        dfs(root.right, treeList);
    }
}
