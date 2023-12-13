package leetcode.lists.lcr;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 22:24
 */
public class LCR174 {

    int res;
    boolean find;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (find) {
            return;
        }
        dfs(root.right);
        k--;
        if (k == 0) {
            res = root.val;
            find = true;
        }
        System.out.println(root.val);
        dfs(root.left);
    }
}
