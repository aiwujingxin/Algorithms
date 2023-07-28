package leetcode.problems;

import common.*;

/**
 * @author jingxinwu
 * @date 2021-08-04 1:30 上午
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode sorted = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (sorted.val <= curr.val) {
                sorted = sorted.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val < curr.val) {
                    pre = pre.next;
                }
                sorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = sorted.next;
        }
        return dummy.next;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);//保存链表地址的指针
        ListNode cur = dummyHead;//当前指针
        ListNode temp1 = list1;
        ListNode temp2 = list2;//保存节点list1,list2
        //135
        //24678
        //123456
        //两个链表都没结束
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                cur.next = temp1;
                temp1 = temp1.next;//循环下一个

            } else {
                cur.next = temp2;
                temp2 = temp2.next;//循环下一个
            }
            cur = cur.next;
        }
        if (temp1 != null) {
            cur.next = temp1;//temp2结束，temp1没结束，链接到cur
        }
        if (temp2 != null) {
            cur.next = temp2;//temp1结束，temp2没结束，链接到cur
        }

        return dummyHead.next;//返回节点
    }

    // 4->2->1->3
    //42
    //24
    //13
    //1234
    //时空效率 nlog2N
    public ListNode MergeSortList(ListNode head, ListNode tail) {
        //链表分段
        //中间节点
        //快慢指针
        if (head == null) {
            return null;
        }
        if (head.next == tail) { //循环条件
            head.next = null;
            return head;
        }
        ListNode slow = head;//循环，1步
        ListNode fast = head;//走两步
        while (fast != tail) {
            fast = fast.next; //快慢指针
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;//中间点
        ListNode list1 = MergeSortList(head, mid);
        ListNode list2 = MergeSortList(mid, tail);
        return Merge(list1, list2);//归并排序
    }

    public ListNode mergeSortList(ListNode head) {
        return MergeSortList(head, null);//递归调用
    }
}
