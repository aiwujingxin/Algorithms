package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/13 21:27
 */
public class LeetCode655 {

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<String>> list = new ArrayList<>();
        int height = get(root) - 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<int[]> index_queue = new LinkedList<>();

        int row = height + 1;
        int col = (int) Math.pow(2, height + 1) - 1;


        int[][] arr = new int[row][col];
        for (int[] ints : arr) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        queue.add(root);
        index_queue.add(new int[]{0, (col / 2)});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int[] index = index_queue.poll();
                arr[index[0]][index[1]] = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                    index_queue.add(new int[]{index[0] + 1, index[1] - (int) Math.pow(2, height - index[0] - 1)});
                }
                if (node.right != null) {
                    queue.add(node.right);
                    index_queue.add(new int[]{index[0] + 1, index[1] + (int) Math.pow(2, height - index[0] - 1)});
                }
            }
        }
        for (int[] ints : arr) {
            List<String> t = new ArrayList<>();
            for (int j = 0; j < arr[0].length; j++) {
                t.add(ints[j] == Integer.MAX_VALUE ? "" : Integer.toString(ints[j]));
            }
            list.add(t);
        }
        return list;
    }

    private int get(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(get(root.left), get(root.right)) + 1;
    }
}
