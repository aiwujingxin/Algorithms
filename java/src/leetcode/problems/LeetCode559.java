package leetcode.problems;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:14
 */
public class LeetCode559 {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (Node node : root.children) {
            int depth = maxDepth(node);
            max = Math.max(max, depth);
        }
        return max + 1;
    }
}
