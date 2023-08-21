package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import common.TreeNode;

public class LeetCode2096_TEL {

    Map<TreeNode, TreeNode> map = new HashMap<>();
    Map<Integer, TreeNode> nodeMap = new HashMap<>();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return "";
        }
        // build
        dfs(root, null);
        // bfs
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> pathQ = new LinkedList<>();

        queue.add(nodeMap.get(startValue));

        String res = "";
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String path = pathQ.poll();

            if (set.contains(node.val)) {
                continue;
            }
            set.add(node.val);
            if (node == nodeMap.get(destValue)) {
                if (res == "") {
                    res = path;
                } else {
                    if (path.length() < res.length()) {
                        res = path;
                    }
                }
            }
            if (node.left != null) {
                queue.add(node.left);
                pathQ.add(path + "L");
            }
            if (node.right != null) {
                queue.add(node.right);
                pathQ.add(path + "R");
            }
            if (map.get(root) != null) {
                queue.add(map.get(root));
                pathQ.add(path + "U");
            }
        }
        return res;
    }

    public void dfs(TreeNode root, TreeNode pa) {
        if (root == null) {
            return;
        }
        nodeMap.put(root.val, root);
        map.put(root, pa);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}