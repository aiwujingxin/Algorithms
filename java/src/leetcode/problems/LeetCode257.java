package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 16:06
 */
public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrack(root, res, new ArrayList<>());
        return res;
    }

    private void backtrack(TreeNode root, List<String> res, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append("->");
                }
            }
            res.add(sb.toString());
            return;
        }
        list.add(root.val);
        backtrack(root.left, res, new ArrayList<>(list));
        backtrack(root.right, res, new ArrayList<>(list));
        list.remove(list.size() - 1);
    }
}
