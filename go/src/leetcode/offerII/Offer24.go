package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/14 16:23
 */

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	var reverse func(node *ListNode) *ListNode
	reverse = func(cur *ListNode) *ListNode {
		if cur.Next == nil {
			return cur
		}
		next := cur.Next
		cur.Next = nil
		newNext := reverse(next)
		next.Next = cur
		return newNext
	}
	return reverse(head)
}
