package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 17:31
 */

func kthToLast(head *ListNode, k int) int {

	cur := head
	length := 0
	for cur != nil {
		length++
		cur = cur.Next
	}

	step := length - k

	node := head
	for step > 0 {
		node = node.Next
		step--
	}
	return node.Val
}
