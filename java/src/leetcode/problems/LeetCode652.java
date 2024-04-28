package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/11 17:43
 */
public class LeetCode652 {

    List<TreeNode> res = new ArrayList<>();

    HashSet<String> set = new HashSet<>();

    HashSet<String> visited = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (!Objects.equals(left, "")) {
            sb.append("(");
            sb.append(left);
            sb.append(")");
        }
        if (!Objects.equals(right, "")) {
            sb.append("(");
            sb.append(right);
            sb.append(")");
        }
        if (set.contains(sb.toString()) && !visited.contains(sb.toString())) {
            res.add(root);
            visited.add(sb.toString());
        }
        set.add(sb.toString());

        return sb.toString();
    }
}
