package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 23:41
 */

func getKthFromEnd(head *ListNode, k int) *ListNode {
	dummy := &ListNode{}
	dummy.Next = head
	pre := dummy
	length := 0
	cur := head
	for cur != nil {
		length++
		cur = cur.Next
	}

	step := length - k
	for step > 0 {
		pre = pre.Next
		step--
	}
	return pre.Next
}
