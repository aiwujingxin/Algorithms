package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/16 15:11
 */
public class LeetCode742 {

    HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    HashMap<Integer, TreeNode> index = new HashMap<>();

    public int findClosestLeaf(TreeNode root, int k) {
        preorder(root);
        //宽度优先遍历队列
        Queue<TreeNode> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int ans = 0;
        //防止重复遍历的visit集合
        Set<TreeNode> visit = new HashSet<>();
        queue.offer(index.get(k));

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                visit.add(node);
                if (node.left == null && node.right == null) {
                    if (node.val != k) {
                        if (level < min) {
                            ans = node.val;
                            min = level;
                        }
                    } else {
                        return k;
                    }

                }
                List<TreeNode> list = map.get(node.val);
                if (list == null) {
                    continue;
                }
                for (TreeNode n : list) {
                    if (!visit.contains(n)) {
                        queue.add(n);
                    }
                }
            }
            level++;
        }
        return ans;
    }

    //从根遍历，深度优先搜索找到每个结点的父节点
    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.putIfAbsent(root.val, new ArrayList<>());
            map.putIfAbsent(root.left.val, new ArrayList<>());
            map.get(root.val).add(root.left);
            map.get(root.left.val).add(root);
        }
        if (root.right != null) {
            map.putIfAbsent(root.val, new ArrayList<>());
            map.putIfAbsent(root.right.val, new ArrayList<>());
            map.get(root.val).add(root.right);
            map.get(root.right.val).add(root);
        }
        index.putIfAbsent(root.val, root);
        preorder(root.left);
        preorder(root.right);
    }
}
