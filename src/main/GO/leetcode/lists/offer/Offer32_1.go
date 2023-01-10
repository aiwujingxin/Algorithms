package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 19:00
 */

func levelOrder32_1(root *TreeNode) []int {

	if root == nil {
		return []int{}
	}
	q := make([]*TreeNode, 0)
	q = append(q, root)
	list := make([]int, 0)
	for len(q) > 0 {
		node := q[0]
		q = q[1:]
		list = append(list, node.Val)
		if node.Left != nil {
			q = append(q, node.Left)
		}
		if node.Right != nil {
			q = append(q, node.Right)
		}
	}
	return list
}
