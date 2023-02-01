package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/14 17:42
 */

//https://leetcode.com/problems/reorder-list/solutions/1774588/c-recursion/
func reorderList(head *ListNode) {
	if head == nil {
		return
	}
	var recursion func(head *ListNode)
	recursion = func(head *ListNode) {
		if head.Next == nil || head.Next.Next == nil {
			return
		}
		temp := head
		for temp.Next.Next != nil {
			temp = temp.Next
		}
		temp.Next.Next = head.Next
		head.Next = temp.Next
		temp.Next = nil
		recursion(head.Next.Next)
	}
	recursion(head)
	return
}

func reorderListMid(head *ListNode) {
	findM := func(head *ListNode) *ListNode {
		slow, right := head, head
		for right != nil && right.Next != nil {
			slow = slow.Next
			right = right.Next.Next
		}
		return slow
	}
	reverse := func(head *ListNode) *ListNode {
		if head == nil || head.Next == nil {
			return head
		}
		pre, cur := head, head.Next
		head.Next = nil
		for cur != nil {
			next := cur.Next
			cur.Next = pre
			pre = cur
			cur = next
		}
		return pre
	}
	mergeList := func(l1, l2 *ListNode) {
		var l1Tmp, l2Tmp *ListNode
		for l1 != nil && l2 != nil {
			l1Tmp = l1.Next
			l2Tmp = l2.Next

			l1.Next = l2
			l1 = l1Tmp

			l2.Next = l1
			l2 = l2Tmp
		}
	}
	mid := findM(head)
	r := mid.Next
	mid.Next = nil
	l2 := reverse(r)
	mergeList(head, l2)
	return
}
