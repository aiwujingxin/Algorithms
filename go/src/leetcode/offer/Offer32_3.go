package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 19:02
 */

func levelOrder32_3(root *TreeNode) [][]int {

	if root == nil {
		return [][]int{}
	}

	q := make([]*TreeNode, 0)
	q = append(q, root)
	list := make([][]int, 0)
	flag := false
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
		list = append(list, level)
		flag = !flag
	}
	return list
}

func Reverse(s []int, start, end int) []int {
	for i, j := start, end; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
	return s
}
