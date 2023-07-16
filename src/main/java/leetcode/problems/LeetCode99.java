package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-07-05 11:58 下午
 */
public class LeetCode99 {

    //https://leetcode.com/problems/recover-binary-search-tree/discuss/1274892/Java-or-Easy-Inorder-Traversal-Soln-or-Faster-than-100-or-Explained
    TreeNode pre, first, second = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null && pre.val > cur.val) {
            if (first == null) {
                first = pre;
            }
            second = cur;
        }
        pre = cur;
        dfs(cur.right);
    }
}
