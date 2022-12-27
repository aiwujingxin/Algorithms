package topinterview

func deleteNode(node *ListNode) {
	if node.Next != nil {
		node.Val = node.Next.Val
		node.Next = node.Next.Next
	} else {
		node = nil
	}
}
