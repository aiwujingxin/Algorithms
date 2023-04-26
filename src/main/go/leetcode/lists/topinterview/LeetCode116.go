package topinterview

func connect(root *Node) *Node {
	if root == nil {
		return nil
	}
	cur := root
	for cur != nil {
		nextLevel := cur.Left
		next := cur
		for next != nil {
			if next.Left != nil {
				next.Left.Next = next.Right
			}
			if next.Right != nil && next.Next != nil {
				next.Right.Next = next.Next.Left
			}
			next = next.Next
		}
		cur = nextLevel
	}
	return root
}
