package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/6 17:42
 */
public class LeetCode1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Deque<TreeNode> q = new ArrayDeque<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(root.val, root);//添加根树
        HashSet<Integer> set = new HashSet<>();
        for (int k : to_delete) {
            set.add(k);
        }
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (set.contains(node.val)) {
                if (map.get(node.val) != null) {
                    map.remove(node.val);
                }
                if (node.left != null) {
                    map.put(node.left.val, node.left);
                }
                if (node.right != null) {
                    map.put(node.right.val, node.right);
                }
            }
            if (node.left != null) {
                q.add(node.left);
                if (set.contains(node.left.val)) {
                    node.left = null;
                }
            }
            if (node.right != null) {
                q.add(node.right);
                if (set.contains(node.right.val)) {
                    node.right = null;
                }
            }
        }
        return new ArrayList<>(map.values());
    }
}
