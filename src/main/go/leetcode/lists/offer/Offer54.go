package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 20:01
 */

func kthLargest(root *TreeNode, k int) int {
	if root == nil {
		return -1
	}
	index := k
	res := root.Val
	var dfs func(root *TreeNode)
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Right)
		index--
		if index == 0 {
			res = root.Val
		}
		dfs(root.Left)
		return
	}
	dfs(root)
	return res
}
