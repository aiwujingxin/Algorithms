package leetcode.competition.doubleweekly.week69;

import common.*;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2022-01-08 10:42 PM
 */
public class Number02 {


    public int pairSum(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i <= (n / 2) - 1; i++) {
            int temp = nums[i] + nums[n - 1 - i];
            res = Math.max(res, temp);
        }
        return res;
    }
}
