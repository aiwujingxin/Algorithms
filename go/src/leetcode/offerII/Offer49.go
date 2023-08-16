package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 17:11
 */

func sumNumbers(root *TreeNode) int {
	var dfs func(root *TreeNode, prevSum int) int
	dfs = func(root *TreeNode, prevSum int) int {
		if root == nil {
			return 0
		}
		sum := prevSum*10 + root.Val
		if root.Left == nil && root.Right == nil {
			return sum
		}
		return dfs(root.Left, sum) + dfs(root.Right, sum)
	}
	return dfs(root, 0)
}
