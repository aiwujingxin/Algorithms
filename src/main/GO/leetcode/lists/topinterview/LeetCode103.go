package topinterview

func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	res := make([][]int, 0)
	q := make([]*TreeNode, 0)
	flag := false
	q = append(q, root)
	for len(q) > 0 {
		size := len(q)
		level := make([]int, 0)
		for size > 0 {
			node := q[0]
			q = q[1:]
			level = append(level, node.Val)
			if node.Left != nil {
				q = append(q, node.Left)
			}
			if node.Right != nil {
				q = append(q, node.Right)
			}
			size--
		}
		if flag {
			Reverse(level, 0, len(level)-1)
		}
		flag = !flag
		res = append(res, level)
	}
	return res
}
