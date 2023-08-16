package hot100

//https://leetcode.com/problems/sort-list/solutions/46754/golang-concise-solution-using-merge-sort/
func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow, fast = slow.Next, fast.Next.Next
	}

	firstTail := slow
	slow = slow.Next
	firstTail.Next = nil // divide the first lists and the second

	first, second := sortList(head), sortList(slow)
	return mergeList(first, second)
}

func mergeList(head1 *ListNode, head2 *ListNode) *ListNode {
	curHead := &ListNode{}
	tmpHead := curHead

	for head1 != nil && head2 != nil {
		if head1.Val < head2.Val {
			curHead.Next = head1
			head1 = head1.Next
			curHead = curHead.Next
		} else {
			curHead.Next = head2
			head2 = head2.Next
			curHead = curHead.Next
		}
	}

	if head1 != nil {
		curHead.Next = head1
	} else if head2 != nil {
		curHead.Next = head2
	}
	return tmpHead.Next
}
