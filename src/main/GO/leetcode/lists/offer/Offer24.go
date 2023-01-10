package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/29 18:36
 */

func reverseList(head *ListNode) *ListNode {
	var dfs func(node *ListNode) *ListNode
	dfs = func(node *ListNode) *ListNode {
		if node == nil || node.Next == nil {
			return node
		}
		next := dfs(node.Next)
		node.Next.Next = node
		node.Next = nil
		return next
	}
	return dfs(head)
}
