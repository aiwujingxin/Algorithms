package topinterview

func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode {

	if root == nil {
		return nil
	}

	var dfs func(root *TreeNode) *TreeNode
	var flag bool
	var res *TreeNode
	dfs = func(root *TreeNode) *TreeNode {
		if root == nil {
			return nil
		}
		dfs(root.Left)
		if flag {
			res = root
			flag = !flag
		}
		if root == p {
			flag = true
		}
		dfs(root.Right)
		return res
	}
	return dfs(root)
}
