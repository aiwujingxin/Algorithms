package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 11:14
 */

func sortList(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	dummy := &ListNode{}
	dummy.Next = head
	sorted := dummy.Next
	cur := sorted.Next
	for cur != nil {
		if cur.Val >= sorted.Val {
			sorted = sorted.Next
		} else {
			pre := dummy
			for pre != nil && pre.Next != nil && pre.Next.Val < cur.Val {
				pre = pre.Next
			}
			sorted.Next = cur.Next
			next := pre.Next
			pre.Next = cur
			cur.Next = next
		}
		cur = sorted.Next
	}
	return dummy.Next
}
