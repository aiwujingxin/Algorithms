package hot100

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	q := make([]*TreeNode, 0)
	q = append(q, root)
	res := make([][]int, 0)
	for len(q) > 0 {
		size := len(q)
		level := make([]int, 0)
		for size > 0 {
			size--
			node := q[0]
			q = q[1:]
			level = append(level, node.Val)

			if node.Left != nil {
				q = append(q, node.Left)
			}
			if node.Right != nil {
				q = append(q, node.Right)
			}
		}
		res = append(res, level)
	}
	return res
}
