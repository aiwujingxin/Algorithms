package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:07
 */
public class LeetCode501 {

    public int[] findMode(TreeNode root) {
        if (null == root) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            map.merge(treeNode.val, 1, Integer::sum);
            if (null != treeNode.left) {
                queue.offer(treeNode.left);
            }
            if (null != treeNode.right) {
                queue.offer(treeNode.right);
            }
        }
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum = Math.max(sum, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (sum == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        int[] index = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            index[i] = list.get(i);
        }
        return index;
    }
}
