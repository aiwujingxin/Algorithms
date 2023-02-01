package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 15:58
 */

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	if head == nil {
		return nil
	}
	length := 0
	dummy := &ListNode{}
	dummy.Next = head
	cur := head
	for cur != nil {
		length++
		cur = cur.Next
	}
	d := dummy
	step := length - n - 1
	for step > 0 {
		d = d.Next
		step--
	}
	d.Next = d.Next.Next
	return dummy.Next
}
