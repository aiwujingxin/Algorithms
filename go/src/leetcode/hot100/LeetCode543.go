package hot100

func diameterOfBinaryTree(root *TreeNode) int {

	var dfs func(root *TreeNode) int
	var max = 0
	dfs = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		l, r := dfs(root.Left), dfs(root.Right)
		max = Max(r+l+1, max)
		return Max(r, l) + 1
	}
	dfs(root)
	return max
}
