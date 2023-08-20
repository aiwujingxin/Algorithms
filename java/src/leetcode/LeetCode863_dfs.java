package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/13 23:35
 */
public class LeetCode863_dfs {

    Map<TreeNode, TreeNode> familyMap = new HashMap<>();
    boolean[] visited;
    List<Integer> res;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        res = new ArrayList<>();
        //递归获取父子结点映射关系
        preorder(root);
        visited = new boolean[501];
        //递归获取距离指定结点指定距离的所有结点值
        search(target, K);
        return res;
    }

    private void search(TreeNode target, int K) {
        if (target == null || K < 0 || visited[target.val]) {
            return;
        }
        if (K == 0 && !visited[target.val]) {
            res.add(target.val);
            visited[target.val] = true;
            return;
        }
        visited[target.val] = true;
        search(target.left, K - 1);
        search(target.right, K - 1);
        search(familyMap.get(target), K - 1);
    }

    private void preorder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            familyMap.put(root.left, root);
        }
        if (root.right != null) {
            familyMap.put(root.right, root);
        }
        preorder(root.left);
        preorder(root.right);
    }
}
