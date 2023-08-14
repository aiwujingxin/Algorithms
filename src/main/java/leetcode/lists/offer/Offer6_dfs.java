package leetcode.lists.offer;

import common.ListNode;

import java.util.ArrayList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 18:07
 */
public class Offer6_dfs {


    ArrayList<Integer> tmp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }

}
