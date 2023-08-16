package leetcode.problems;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/14 17:31
 */
public class LeetCode2385 {

    HashMap<Integer, TreeNode> parentMap = new HashMap<>();
    HashMap<Integer, TreeNode> map = new HashMap<>();
    HashSet<Integer> set;


    public int amountOfTime(TreeNode root, int start) {
        dfs(null, root);
        set = new HashSet<>();


        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(map.get(start));
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (set.contains(node.val)) {
                    continue;
                }
                set.add(node.val);
                if (set.size() == map.size()) {
                    return time;
                }
                if (parentMap.get(node.val) != null) {
                    queue.add(parentMap.get(node.val));
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            time++;

        }
        return time;
    }


    private void dfs(TreeNode pa, TreeNode root) {
        if (root == null) {
            return;
        }
        parentMap.putIfAbsent(root.val, pa);
        map.putIfAbsent(root.val, root);
        dfs(root, root.left);
        dfs(root, root.right);
    }
}
