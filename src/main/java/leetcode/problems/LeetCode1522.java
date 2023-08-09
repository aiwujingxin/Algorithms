package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/2 21:29
 */
public class LeetCode1522 {


    int ans = 0;

    public int diameter(Node root) {
        maxDepth(root);
        return ans;
    }

    private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxLen = 0;

        for (Node next : root.children) {
            int mx = maxDepth(next);
            ans = Math.max(ans, mx + maxLen);
            maxLen = Math.max(mx, maxLen);
        }
        return 1 + maxLen;
    }
}
