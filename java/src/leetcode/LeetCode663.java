package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:30
 */
public class LeetCode663 {

    public int sum = Integer.MIN_VALUE;//总和
    public boolean flag = false; //假定不行


    public boolean checkEqualTree(TreeNode root) {
        sum = dfs(root);//根节点
        dfs(root.left);
        dfs(root.right);
        return flag;//标记行不行
    }


    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);//递归左右
        int t = root.val + left + right;
        if (t == (double) sum / 2) {
            flag = true;//可以拆分
        }
        return t;//返回结果
    }
}
