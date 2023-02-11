package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 17:38
 */

func checkSubTree(t1 *TreeNode, t2 *TreeNode) bool {
	if t1 == nil && t2 == nil {
		return true
	}
	if t1 == nil || t2 == nil {
		return false
	}
	var checkSub func(t1, t2 *TreeNode) bool
	checkSub = func(t1, t2 *TreeNode) bool {
		if t1 == nil && t2 == nil {
			return true
		}
		if t1 == nil || t2 == nil {
			return false
		}
		if t1.Val != t2.Val {
			return false
		}
		return checkSub(t1.Left, t2.Left) && checkSub(t1.Right, t2.Right)
	}

	//如果节点值相等，则需要判断子树完全相等
	if t1.Val == t2.Val && checkSub(t1.Left, t2.Left) && checkSub(t2.Right, t2.Right) {
		return true
	}
	return checkSubTree(t1.Left, t2) || checkSubTree(t1.Right, t2)
}
