package hot100

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	dummy := &ListNode{}
	var dfs func(list1, list2, node *ListNode)
	dfs = func(list1, list2, node *ListNode) {
		if list1 == nil {
			node.Next = list2
			return
		}
		if list2 == nil {
			node.Next = list1
			return
		}

		if list1 == nil && list2 == nil {
			return
		}
		if list1.Val < list2.Val {
			node.Next = list1
			dfs(list1.Next, list2, node.Next)
		} else {
			node.Next = list2
			dfs(list1, list2.Next, node.Next)
		}
	}
	dfs(list1, list2, dummy)
	return dummy.Next
}
