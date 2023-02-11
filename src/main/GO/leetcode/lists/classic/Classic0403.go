package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 17:18
 */

func listOfDepth(tree *TreeNode) []*ListNode {
	if tree == nil {
		return []*ListNode{}
	}
	q := make([]*TreeNode, 0)
	q = append(q, tree)
	res := make([]*ListNode, 0)
	for len(q) > 0 {
		size := len(q)
		dummy := &ListNode{}
		cur := dummy
		for size > 0 {
			node := q[0]
			q = q[1:]
			cur.Next = &ListNode{
				Val: node.Val,
			}
			cur = cur.Next
			if node.Left != nil {
				q = append(q, node.Left)
			}
			if node.Right != nil {
				q = append(q, node.Right)
			}
			size--
		}
		res = append(res, dummy.Next)
	}
	return res
}
