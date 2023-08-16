package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/6 22:04
 */

func pathSum(root *TreeNode, sum int) int {
	var res = 0

	if root == nil {
		return 0
	}
	var dfs func(root *TreeNode, sum int, cur int)
	dfs = func(root *TreeNode, sum int, cur int) {
		if root == nil {
			return
		}
		cur = cur + root.Val
		if cur == sum {
			res++
		}
		dfs(root.Left, sum, cur)
		dfs(root.Right, sum, cur)
	}
	dfs(root, sum, 0)
	return res + pathSum(root.Left, sum) + pathSum(root.Right, sum)
}
