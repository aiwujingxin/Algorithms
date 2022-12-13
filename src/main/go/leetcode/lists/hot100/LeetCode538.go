package hot100

func convertBST(root *TreeNode) *TreeNode {

	if root == nil {
		return nil
	}
	var dfs func(root *TreeNode)
	last := 0
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Right)
		root.Val = last + root.Val
		last = root.Val
		dfs(root.Left)
		return
	}
	dfs(root)
	return root
}
