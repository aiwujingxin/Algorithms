package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 20:33
 */

func getIntersectionNode(headA, headB *ListNode) *ListNode {

	if headA == nil || headB == nil {
		return nil
	}
	A, B := headA, headB
	for A != B {
		if A == nil {
			A = headB
		} else {
			A = A.Next
		}
		if B == nil {
			B = headA
		} else {
			B = B.Next
		}
	}
	return A
}
