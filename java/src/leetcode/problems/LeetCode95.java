package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 23:16
 */
public class LeetCode95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int i, int j) {
        List<TreeNode> res = new ArrayList<>();
        if (i > j) {
            res.add(null);
            return res;
        }
        for (int k = i; k <= j; k++) {
            for (TreeNode l : dfs(i, k - 1)) {
                for (TreeNode r : dfs(k + 1, j)) {
                    TreeNode root = new TreeNode(k);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
