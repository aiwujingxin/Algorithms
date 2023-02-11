package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 17:26
 */

func isValidBST(root *TreeNode) bool {
	var valid func(root, max, min *TreeNode) bool

	valid = func(root, max, min *TreeNode) bool {

		if root == nil {
			return true
		}
		if max != nil && root.Val >= max.Val {
			return false
		}
		if min != nil && root.Val <= min.Val {
			return false
		}
		return valid(root.Left, root, min) && valid(root.Right, max, root)

	}
	return valid(root, nil, nil)
}
