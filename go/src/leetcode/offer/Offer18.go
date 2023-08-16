package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 23:36
 */

func deleteNode(head *ListNode, val int) *ListNode {
	dummy := &ListNode{}
	dummy.Next = head
	pre := dummy
	cur := pre.Next
	for cur != nil && cur.Val != val {
		cur = cur.Next
		pre = pre.Next
	}
	pre.Next = cur.Next
	return dummy.Next
}
