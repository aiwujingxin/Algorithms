package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 18:52
 */

func isSubStructure(A *TreeNode, B *TreeNode) bool {
    if A == nil || B == nil {
        return false
    }
	var dfs func(A *TreeNode, B *TreeNode) bool
	dfs = func(A *TreeNode, B *TreeNode) bool {
	    if (A == null && B == null) {
            return true;
        }
		if A == nil {
			return false
		}
        if B == nil {
            return true
        }
        if A.Val != B.Val {
            return false
        }
		return dfs(A.Left, B.Left) && dfs(A.Right, B.Right)
	}
	return dfs(A, B) || isSubStructure(A.Left, B) || isSubStructure(A.Right, B)
}