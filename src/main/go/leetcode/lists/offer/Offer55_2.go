package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 19:55
 */

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	var hi func(root *TreeNode) int

	hi = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		return Max(hi(root.Left), hi(root.Right)) + 1
	}

	return Abs(hi(root.Left)-hi(root.Right)) <= 1 && isBalanced(root.Left) && isBalanced(root.Right)
}
