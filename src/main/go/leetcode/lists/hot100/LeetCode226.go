package hot100

func invertTree(root *TreeNode) *TreeNode {

	if root == nil {
		return nil
	}
	var invertTree func(*TreeNode)

	invertTree = func(node *TreeNode) {
		if node == nil {
			return
		}
		node.Left, node.Right = node.Right, node.Left
		invertTree(node.Left)
		invertTree(node.Right)
	}
	invertTree(root)
	return root
}
