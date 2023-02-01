package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/18 19:03
 */

func maxPathSum(root *TreeNode) int {
	if root == nil {
		return 0
	}
	max := math.MinInt32
	var dfs func(node *TreeNode) int
	dfs = func(node *TreeNode) int {
		if node == nil {
			return 0
		}
		leftMax := dfs(node.Left)
		rightMax := dfs(node.Right)
		max = Max(Max(Max(Max(node.Val+leftMax, node.Val+rightMax), node.Val), node.Val+leftMax+rightMax), max)
		return Max(Max(leftMax+node.Val, rightMax+node.Val), node.Val)
	}
	dfs(root)
	return max
}
