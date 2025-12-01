package leetcode.problems;

import common.ListNode;
import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 23:47
 * @description 注意事项
 * 1. 开区间 [l, r)
 * 2. 不需要断链，因为 (l, r) 已经定义了递归的有效区间
 * 3. 偏左中点
 */
public class LeetCode109 {

    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    TreeNode build(ListNode l, ListNode r) {
        if (l == r) return null;
        ListNode s = l, f = l;
        while (f.next != r && f.next.next != r) {
            s = s.next;
            f = f.next.next;
        }
        TreeNode root = new TreeNode(s.val);
        root.left = build(l, s);
        root.right = build(s.next, r);
        return root;
    }
}
