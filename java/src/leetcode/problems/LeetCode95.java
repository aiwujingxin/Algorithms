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
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        if (start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        if (start == end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    r.left = l;
                    r.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
