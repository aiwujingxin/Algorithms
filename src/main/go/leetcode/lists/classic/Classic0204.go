package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/6 16:33
 */

func partition(head *ListNode, x int) *ListNode {

	if head == nil || head.Next == nil {
		return head
	}
	dummy := &ListNode{}
	dummy.Next = head
	sorted, pre := dummy, dummy
	for pre != nil && pre.Next != nil {
		if pre.Next.Val < x {
			pre = pre.Next
		} else {
			cur := pre.Next
			for cur != nil {
				if cur.Val >= x {
					cur = cur.Next
					pre = pre.Next
				} else {

					pre.Next = cur.Next
					t := sorted.Next
					sorted.Next = cur
					cur.Next = t

					cur = pre.Next
				}
			}
		}
	}
	return dummy.Next
}
