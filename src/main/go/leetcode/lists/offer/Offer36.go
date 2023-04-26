package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 15:15
 */

func treeToDoublyList(root *TreeNode) *TreeNode {
	var dfs func(cur *TreeNode)
	var pre, head *TreeNode
	dfs = func(cur *TreeNode) {
		if cur == nil {
			return
		}
		dfs(cur.Left)
		if pre != nil {
			pre.Right = cur
		} else {
			head = cur
		}
		cur.Left = pre
		pre = cur
		dfs(cur.Right)
	}
	dfs(root)
	return head
}
