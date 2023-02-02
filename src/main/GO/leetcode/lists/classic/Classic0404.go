package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 18:30
 */

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return Abs(height(root.Left)-height(root.Right)) <= 1 && isBalanced(root.Left) && isBalanced(root.Right)
}

func height(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return Max(height(root.Left), height(root.Right)) + 1
}
