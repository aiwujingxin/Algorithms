package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 18:52
 */

func isSubStructure(A *TreeNode, B *TreeNode) bool {

	var dfs func(A *TreeNode, B *TreeNode) bool
	dfs = func(A *TreeNode, B *TreeNode) bool {
		if B == nil {
			return true
		}
		if A == nil || A.Val != B.Val {
			return false
		}
		return dfs(A.Left, B.Left) && dfs(A.Right, B.Right)
	}
	return (A != nil && B != nil) && (dfs(A, B) || isSubStructure(A.Left, B) || isSubStructure(A.Right, B))
}
