package topinterview

func oddEvenList(head *ListNode) *ListNode {

	if head == nil || head.Next == nil {
		return head
	}

	odd, even := head, head.Next

	for even != nil {

		node := even.Next
		if node == nil {
			break
		}
		even.Next = node.Next
		node.Next = odd.Next

		odd.Next = node

		odd = odd.Next
		even = even.Next
	}
	return head

}
