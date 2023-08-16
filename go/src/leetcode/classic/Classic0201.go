package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 17:13
 */

func removeDuplicateNodes(head *ListNode) *ListNode {

	if head == nil || head.Next == nil {
		return head
	}

	cur := head

	for cur != nil {
		curVal := cur.Val
		pre := cur
		d := cur.Next
		for d != nil {
			if d.Val == curVal {
				pre.Next = d.Next

			} else {
				pre = pre.Next
			}
			d = d.Next
		}
		cur = cur.Next
	}
	return head
}
