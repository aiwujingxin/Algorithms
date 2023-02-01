package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/17 18:30
 */

func convertBST(root *TreeNode) *TreeNode {

	if root == nil {
		return nil
	}
	sum := 0
	var dfs func(root *TreeNode)
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Right)
		//op
		root.Val += sum
		sum = root.Val
		dfs(root.Left)
	}
	dfs(root)
	return root
}
