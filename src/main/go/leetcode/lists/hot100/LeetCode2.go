package hot100

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	root := &ListNode{}
	helperAdd(l1, l2, root, 0)
	return root.Next
}

func helperAdd(l1 *ListNode, l2 *ListNode, root *ListNode, flag int) {
	if l1 == nil && l2 == nil {
		if flag == 1 {
			root.Next = &ListNode{Val: 1}
		}
		return
	}
	var v1, v2 int
	var n1, n2 *ListNode
	if l1 == nil {
		v1 = 0
		n1 = nil
	} else {
		v1 = l1.Val
		n1 = l1.Next
	}
	if l2 == nil {
		v2 = 0
		n2 = nil
	} else {
		v2 = l2.Val
		n2 = l2.Next
	}
	root.Next = &ListNode{
		Val: (v1 + v2 + flag) % 10,
	}
	flag = (v1 + v2 + flag) / 10
	helperAdd(n1, n2, root.Next, flag)
}
