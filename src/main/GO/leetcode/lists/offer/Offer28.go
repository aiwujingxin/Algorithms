package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/29 19:09
 */

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	var dfs func(node1, node2 *TreeNode) bool
	dfs = func(left, right *TreeNode) bool {
		if left == nil && right != nil {
			return false
		}
		if right == nil && left != nil {
			return false
		}
		if left == nil && right == nil {
			return true
		}
		if left.Val != right.Val {
			return false
		}
		return dfs(left.Right, right.Left) && dfs(left.Left, right.Right)
	}
	return dfs(root.Left, root.Right)
}
