package hot100

func isSymmetric(root *TreeNode) bool {
	var dfs func(l, r *TreeNode) bool
	dfs = func(l, r *TreeNode) bool {
		if l == nil && r == nil {
			return true
		}
		if l == nil && r != nil || r == nil && l != nil || l.Val != r.Val {
			return false
		}
		return dfs(l.Left, r.Right) && dfs(l.Right, r.Left)
	}

	return dfs(root.Left, root.Right)
}
