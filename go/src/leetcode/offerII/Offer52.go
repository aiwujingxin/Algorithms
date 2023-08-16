package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/17 16:28
 */

func increasingBST(root *TreeNode) *TreeNode {
	dummyNode := &TreeNode{}
	resNode := dummyNode

	var dfs func(*TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Left)
		//操作
		resNode.Right = node
		node.Left = nil
		resNode = node
		dfs(node.Right)
	}
	dfs(root)
	return dummyNode.Right
}
