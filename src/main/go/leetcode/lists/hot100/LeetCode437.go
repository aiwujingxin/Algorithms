package hot100

func pathSum(root *TreeNode, targetSum int) int {
	if root == nil {
		return 0
	}
	var dfs func(*TreeNode, int) int
	dfs = func(root *TreeNode, targetSum int) int {
		var count int
		if root == nil {
			return 0
		}
		if root.Val == targetSum {
			count++
		}
		count += dfs(root.Left, targetSum-root.Val)
		count += dfs(root.Right, targetSum-root.Val)
		return count
	}
	return dfs(root, targetSum) + pathSum(root.Left, targetSum) + pathSum(root.Right, targetSum)
}
