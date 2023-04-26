package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 17:17
 */

//[-2,null,-3]
//-5

func pathSum(root *TreeNode, targetSum int) int {
	if root == nil {
		return 0
	}
	var dfs func(node *TreeNode, sum, targetSum int) int
	dfs = func(node *TreeNode, sum, targetSum int) int {
		var res = 0
		if node == nil {
			return 0
		}

		if sum+node.Val == targetSum {
			res++
		}
		res += dfs(node.Left, sum+node.Val, targetSum)
		res += dfs(node.Right, sum+node.Val, targetSum)
		return res
	}
	return dfs(root, 0, targetSum) + pathSum(root.Left, targetSum) + pathSum(root.Right, targetSum)
}
