package hot100

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	var pre, next = head, head.Next
	pre.Next = nil
	for next != nil {
		temp := next.Next
		next.Next = pre
		pre = next
		next = temp
	}
	return pre
}
