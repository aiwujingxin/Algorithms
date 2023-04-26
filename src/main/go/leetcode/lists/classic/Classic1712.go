package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 22:17
 */

func convertBiNode(root *TreeNode) *TreeNode {
	dummy := &TreeNode{Val: 0}
	var pre *TreeNode

	var dfs func(*TreeNode)
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Left)
		if pre == nil {
			pre = root
			dummy.Right = root
		} else {
			pre.Right = root
			pre = root
		}
		root.Left = nil
		dfs(root.Right)
	}
	dfs(root)
	return dummy.Right
}
