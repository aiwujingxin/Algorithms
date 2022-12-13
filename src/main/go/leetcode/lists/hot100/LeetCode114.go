package hot100

func flatten(root *TreeNode) {

	if root == nil {
		return
	}

	stack := make([]*TreeNode, 0)
	stack = append(stack, root)
	for len(stack) > 0 {
		cur := stack[len(stack)-1]
		stack = stack[0 : len(stack)-1]
		if cur.Right != nil {
			stack = append(stack, cur.Right)
		}
		if cur.Left != nil {
			stack = append(stack, cur.Left)
		}
		if len(stack) > 0 {
			cur.Right = stack[len(stack)-1]
			stack = stack[0 : len(stack)-1]
		}
		cur.Left = nil
	}
}
