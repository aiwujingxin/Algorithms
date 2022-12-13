package hot100

func robIII(root *TreeNode) int {
	if root == nil {
		return 0
	}
	var dfs func(node *TreeNode) (int, int)
	dfs = func(node *TreeNode) (int, int) {
		if node == nil {
			return 0, 0
		}
		lRob, lNo := dfs(node.Left)
		rRob, rNo := dfs(node.Right)
		nRob := lNo + rNo + node.Val
		//fix
		nNo := Max(lRob, lNo) + Max(rRob, rNo)
		return nRob, nNo
	}
	rob, no := dfs(root)
	return Max(rob, no)
}
