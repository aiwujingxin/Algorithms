package leetcode.problems;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/2 21:29
 */
public class LeetCode1522 {

    int ans = 0;

    public int diameter(Node root) {
        dfs(root);
        return ans;
    }

    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        int maxLen = 0;
        for (Node ch : root.children) {
            int mx = dfs(ch);
            ans = Math.max(ans, mx + maxLen);
            maxLen = Math.max(mx, maxLen);
        }
        return 1 + maxLen;
    }
}
