package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/29 19:02
 */

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := &ListNode{}
	cur := dummy
	var dfs func(l1 *ListNode, l2 *ListNode, cur *ListNode)
	dfs = func(l1 *ListNode, l2 *ListNode, cur *ListNode) {
		if l1 == nil && l2 != nil {
			cur.Next = l2
			return
		}
		if l1 != nil && l2 == nil {
			cur.Next = l1
			return
		}
		if l1 == nil && l2 == nil {
			return
		}
		if l1.Val < l2.Val {
			cur.Next = l1
			dfs(l1.Next, l2, cur.Next)
		} else {
			cur.Next = l2
			dfs(l1, l2.Next, cur.Next)
		}
	}
	dfs(l1, l2, cur)
	return dummy.Next
}
