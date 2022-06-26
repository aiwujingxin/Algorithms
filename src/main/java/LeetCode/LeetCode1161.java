package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/20 22:34
 */
public class LeetCode1161 {

    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        int depth = 0;
        int curLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            curLevel++;
            while (size > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            if (max < sum) {
                depth = curLevel;
            }
        }
        return depth;
    }
}

