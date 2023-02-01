package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 17:52
 */

//后序遍历
func pruneTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	root.Left = pruneTree(root.Left)
	root.Right = pruneTree(root.Right)
	if root.Left == nil && root.Right == nil && root.Val == 0 {
		return nil
	}
	return root
}
