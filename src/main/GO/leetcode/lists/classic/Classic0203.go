package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 17:33
 */

func deleteNode(node *ListNode) {
	*node = *node.Next
}
