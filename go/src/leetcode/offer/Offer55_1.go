package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/30 23:54
 */

func maxDepth(root *TreeNode) int {

	if root == nil {
		return 0
	}
	return Max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}
