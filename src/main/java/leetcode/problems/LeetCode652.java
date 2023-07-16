package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/11 17:43
 */
public class LeetCode652 {

    Map<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        String serial = node.val +
                "(" +
                dfs(node.left) +
                ")" +
                "(" +
                dfs(node.right) +
                ")";
        if (seen.containsKey(serial)) {
            repeat.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }
        return serial;
    }
}
