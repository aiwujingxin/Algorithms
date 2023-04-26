package hot100

func isValidBST(root *TreeNode) bool {
	if root == nil {
		return true
	}
	var isValidBST func(root, max, min *TreeNode) bool
	isValidBST = func(root, max, min *TreeNode) bool {
		if root == nil {
			return true
		}
		if max != nil && root.Val >= max.Val {
			return false
		}
		if min != nil && root.Val <= min.Val {
			return false
		}
		return isValidBST(root.Left, root, min) && isValidBST(root.Right, max, root)
	}
	return isValidBST(root, nil, nil)
}
