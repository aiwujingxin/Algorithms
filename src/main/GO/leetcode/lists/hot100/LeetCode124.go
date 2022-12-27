package hot100

import "math"

func maxPathSum(root *TreeNode) int {
	if root == nil {
		return 0
	}
	max := math.MinInt32
	var dfs func(root *TreeNode) int
	dfs = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		l := Max(dfs(root.Left), 0)
		r := Max(dfs(root.Right), 0)
		max = Max(max, l+r+root.Val)
		return Max(l, r) + root.Val
	}
	dfs(root)
	return max
}
