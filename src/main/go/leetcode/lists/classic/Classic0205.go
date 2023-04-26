package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 17:33
 */

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {

	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	one, two := l1, l2
	flag := 0
	dummy := &ListNode{}
	cur := dummy
	for one != nil || two != nil {
		var val1, val2 int
		if one == nil {
			val1 = 0
		} else {
			val1 = one.Val
			one = one.Next
		}
		if two == nil {
			val2 = 0
		} else {
			val2 = two.Val
			two = two.Next
		}
		sum := val1 + val2 + flag
		flag = sum / 10
		cur.Next = &ListNode{
			Val: sum % 10,
		}
		cur = cur.Next
	}
	if flag == 1 {
		cur.Next = &ListNode{
			Val: 1,
		}
	}
	return dummy.Next
}
