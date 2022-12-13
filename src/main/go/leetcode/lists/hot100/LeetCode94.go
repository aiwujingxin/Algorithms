package hot100

func inorderTraversal(root *TreeNode) []int {
	var list []int

	inorderTraversalDfs(root, &list)
	return list
}

func inorderTraversalDfs(root *TreeNode, list *[]int) {
	if root == nil {
		return
	}
	inorderTraversalDfs(root.Left, list)
	*list = append(*list, root.Val)
	inorderTraversalDfs(root.Right, list)
}

func inorderTraversal_V2(root *TreeNode) []int {
	var list []int
	if root == nil {
		return list
	}
	var stack []*TreeNode
	for root != nil || len(stack) != 0 {
		for root != nil {
			stack = append(stack, root)
			root = root.Left
		}
		root = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		list = append(list, root.Val)
		root = root.Right
	}
	return list
}
