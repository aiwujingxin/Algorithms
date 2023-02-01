package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 16:58
 */

func largestValues(root *TreeNode) []int {

	if root == nil {
		return []int{}
	}

	q := make([]*TreeNode, 0)
	q = append(q, root)
	res := make([]int, 0)
	for len(q) > 0 {
		size := len(q)
		max := math.MinInt32
		for size > 0 {
			node := q[0]
			q = q[1:]
			if max < node.Val {
				max = node.Val
			}
			if node.Left != nil {
				q = append(q, node.Left)
			}
			if node.Right != nil {
				q = append(q, node.Right)
			}
			size--
		}
		res = append(res, max)
	}
	return res
}
