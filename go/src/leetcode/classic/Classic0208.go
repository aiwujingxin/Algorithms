package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/6 17:29
 */

func detectCycle(head *ListNode) *ListNode {

	if head == nil || head.Next == nil {
		return nil
	}

	slow, fast := head, head

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			fast = head
			for slow != fast {
				slow = slow.Next
				fast = fast.Next
			}
			return slow
		}
	}
	return nil
}
