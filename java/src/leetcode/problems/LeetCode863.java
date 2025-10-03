package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/13 23:23
 */
public class LeetCode863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> paMap = new HashMap<>();
        dfs(paMap, root, null);
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        set.add(target.val);
        List<List<Integer>> levelList = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    if (!set.contains(node.left.val)) {
                        set.add(node.left.val);
                        q.add(node.left);
                    }

                }
                if (node.right != null) {
                    if (!set.contains(node.right.val)) {
                        q.add(node.right);
                        set.add(node.right.val);
                    }

                }
                if (paMap.get(node) != null) {
                    if (!set.contains(paMap.get(node).val)) {
                        set.add(paMap.get(node).val);
                        q.add(paMap.get(node));
                    }

                }
            }
            levelList.add(list);
        }

        if (k >= levelList.size()) {
            return new ArrayList<>();
        }
        return levelList.get(k);
    }

    public void dfs(HashMap<TreeNode, TreeNode> paMap, TreeNode root, TreeNode pa) {
        if (root == null) {
            return;
        }
        paMap.put(root, pa);
        dfs(paMap, root.right, root);
        dfs(paMap, root.left, root);
    }
}
