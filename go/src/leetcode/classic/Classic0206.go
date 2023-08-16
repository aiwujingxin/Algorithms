package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 17:39
 */

func isPalindrome(head *ListNode) bool {

	var dfs func(node *ListNode) bool
	cur := head
	dfs = func(node *ListNode) bool {
		if node == nil {
			return true
		}
		if !dfs(node.Next) {
			return false
		}
		if node.Val != cur.Val {
			return false
		}
		cur = cur.Next
		return true
	}

	return dfs(head)
}
