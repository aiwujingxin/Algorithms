package leetcode.lists.lcr;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 13:26
 */
public class LCR123 {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        dfs(head, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        dfs(head.next, list);
        list.add(head.val);
    }
}
