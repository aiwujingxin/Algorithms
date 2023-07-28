package leetcode.lists.classic;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:14
 */
public class Number0403 {

    List<ListNode> list = new ArrayList<>();

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[]{};
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                head.next = new ListNode(node.val);
                head = head.next;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(dummy.next);
        }
        return list.toArray(new ListNode[0]);
    }
}
