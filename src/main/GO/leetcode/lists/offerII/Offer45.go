package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 17:04
 */

func findBottomLeftValue(root *TreeNode) int {

	if root == nil {
		return 0
	}

	q := make([]*TreeNode, 0)
	q = append(q, root)
	list := make([][]int, 0)
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
		list = append(list, level)
	}
	return list[len(list)-1][0]
}
