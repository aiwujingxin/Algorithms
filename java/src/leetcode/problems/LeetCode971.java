package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 18:12
 */
public class LeetCode971 {

    int index = 0;
    List<Integer> res = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage)) {
            return res;
        }
        return List.of(-1);
    }

    boolean dfs(TreeNode root, int[] v) {
        if (root == null) {
            return true;
        }

        if (root.val != v[index++]) {
            return false;
        }

        if (root.left != null && root.left.val != v[index]) {
            res.add(root.val);
            return dfs(root.right, v) && dfs(root.left, v);
        }
        return dfs(root.left, v) && dfs(root.right, v);
    }
}
