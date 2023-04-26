package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/29 19:12
 */

func mirrorTree(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}
	root.Right, root.Left = root.Left, root.Right
	mirrorTree(root.Left)
	mirrorTree(root.Right)
	return root
}
