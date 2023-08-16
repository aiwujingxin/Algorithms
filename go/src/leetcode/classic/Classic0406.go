package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 17:30
 */

func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode {

	var ans *TreeNode
	var dfs func(root *TreeNode)
	flag := false
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Left)
		//root
		if flag {
			ans = root
			flag = false
		}
		if root.Val == p.Val {
			flag = true
		}

		dfs(root.Right)
	}
	dfs(root)
	return ans
}
