package leetcode;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/13 23:23
 */
public class LeetCode863_bfs {

    //存储各个结点的父节点
    private final Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) {
            ans.add(target.val);
            return ans;
        }
        preorder(root);
        //宽度优先遍历队列
        Queue<TreeNode> queue = new LinkedList<>();
        //防止重复遍历的visit集合
        Set<TreeNode> visit = new HashSet<>();
        queue.offer(target);

        while (!queue.isEmpty()) {
            int size = queue.size();
            k--;
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                visit.add(node);
                List<TreeNode> list = map.get(node);
                if (list == null) {
                    continue;
                }
                for (TreeNode n : list) {
                    if (!visit.contains(n)) {
                        queue.add(n);
                    }
                }
            }
            if (k == 0) {
                for (TreeNode node : queue) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

    //从根遍历，深度优先搜索找到每个结点的父节点
    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.putIfAbsent(root, new ArrayList<>());
            map.putIfAbsent(root.left, new ArrayList<>());
            map.get(root).add(root.left);
            map.get(root.left).add(root);
        }
        if (root.right != null) {
            map.putIfAbsent(root, new ArrayList<>());
            map.putIfAbsent(root.right, new ArrayList<>());
            map.get(root).add(root.right);
            map.get(root.right).add(root);
        }
        preorder(root.left);
        preorder(root.right);
    }
}
