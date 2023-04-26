package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 15:39
 */

//[1,3,5]
//4

func insert(head *Node, x int) *Node {
	node := &Node{Val: x}
	//corn case
	if head == nil {
		node.Next = node
		return node
	}
	if head.Next == head {
		head.Next = node
		node.Next = head
		return head
	}
	curr, next := head, head.Next
	for next != head {
		if x >= curr.Val && x <= next.Val {
			break
		}
		if curr.Val > next.Val {
			if x > curr.Val || x < next.Val {
				break
			}
		}
		curr = curr.Next
		next = next.Next
	}
	curr.Next = node
	node.Next = next
	return head
}
