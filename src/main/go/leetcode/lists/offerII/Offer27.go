package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 13:33
 */

//[1,1,2,1]
func isPalindromeL(head *ListNode) bool {
	var isPalindrome func(node *ListNode) bool
	pre := head
	isPalindrome = func(node *ListNode) bool {
		if node == nil || pre == nil {
			return true
		}
		if node.Next == nil && pre.Val != node.Val {
			return false
		}
		if !isPalindrome(node.Next) {
			return false
		}
		if node.Val != pre.Val {
			return false
		}
		pre = pre.Next
		return true
	}
	return isPalindrome(head)
}
