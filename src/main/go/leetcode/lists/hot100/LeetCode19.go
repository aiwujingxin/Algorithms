package hot100

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	if head == nil {
		return nil
	}
	length, step, node, dummy, cur := 0, 0, head, &ListNode{}, &ListNode{}
	dummy.Next = head
	for node != nil {
		length++
		node = node.Next
	}
	step = length - n
	cur = dummy
	for step > 0 {
		cur = cur.Next
		step--
	}
	cur.Next = cur.Next.Next
	return dummy.Next
}
