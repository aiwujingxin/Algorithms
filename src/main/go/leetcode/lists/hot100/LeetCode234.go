package hot100

func isPalindrome(head *ListNode) bool {

	if head == nil || head.Next == nil {
		return true
	}
	normalNode := head
	var reverseCheck func(node *ListNode) bool
	reverseCheck = func(node *ListNode) bool {
		if node != nil {
			if !reverseCheck(node.Next) {
				return false
			}
			if normalNode.Val != node.Val { // 最开始是从这里比较的 比较的是头节点和尾节点
				return false
			}
			normalNode = normalNode.Next
		}
		return true
	}
	return reverseCheck(head)
}
