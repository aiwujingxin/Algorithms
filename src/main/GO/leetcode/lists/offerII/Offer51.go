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
		leftMax := Max(0, dfs(node.Left))
		rightMax := Max(0, dfs(node.Right))
		max = Max(Max(Max(Max(node.Val+leftMax, node.Val+rightMax), node.Val+leftMax+rightMax), node.Val), max)
		return Max(leftMax, rightMax) + node.Val
	}
	dfs(root)
	return max
}
