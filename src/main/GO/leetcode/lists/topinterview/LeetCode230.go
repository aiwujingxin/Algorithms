package topinterview

func kthSmallest(root *TreeNode, k int) int {

	if root == nil {
		return 0
	}
	cnt := 0
	res := 1
	var dfs func(root *TreeNode)
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Left)
		cnt++
		if cnt == k {
			res = root.Val
			return
		}
		dfs(root.Right)
	}
	dfs(root)
	return res
}
