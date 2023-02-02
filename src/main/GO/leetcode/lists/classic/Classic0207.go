package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 17:45
 */

func getIntersectionNode(headA, headB *ListNode) *ListNode {

	if headA == headB {
		return headB
	}

	nodeA := headA
	nodeB := headB

	for nodeA != nil || nodeB != nil {

		if nodeA == nil {
			nodeA = headB
		} else {
			nodeA = nodeA.Next
		}
		if nodeB == nil {
			nodeB = headA
		} else {
			nodeB = nodeB.Next
		}
		if nodeA == nodeB {
			return nodeA
		}
	}
	return nodeA
}
