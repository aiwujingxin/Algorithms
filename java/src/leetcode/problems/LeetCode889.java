package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/12 00:15
 */
public class LeetCode889 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, 0, postorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] pre, int pre_s, int pre_e, int[] pos, int po_s, int po_e) {
        if (pre_s > pre_e || po_s > po_e) return null;
        TreeNode root = new TreeNode(pre[pre_s]);
        if (pre_s == pre_e) return root; // 不需要继续
        int i = po_s;
        int len = 0;
        while (i < po_e && pos[i] != pre[pre_s + 1]) {
            i++;
            len++;
        }
        root.left = buildTree(pre, pre_s + 1, pre_s + len + 1, pos, po_s, i);
        root.right = buildTree(pre, pre_s + len + 2, pre_e, pos, i + 1, po_e - 1);
        return root;
    }
}
