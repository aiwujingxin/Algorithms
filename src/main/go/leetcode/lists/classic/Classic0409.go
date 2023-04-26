package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/27 22:03
 */

func BSTSequences(root *TreeNode) [][]int {

	if root == nil {
		return [][]int{{}}
	}

	var result [][]int
	q := make([]*TreeNode, 0)
	q = append(q, root)

	var dfs func(dq []*TreeNode, path []int)

	dfs = func(q []*TreeNode, path []int) {
		if len(q) == 0 {
			result = append(result, append([]int(nil), path...))
			return
		}

		size := len(q)
		for i := 0; i < size; i++ {
			cur := q[0]

			q = q[1:]
			//每一个节点都必须排在它的子孙结点前面
			//任一节点root的子节点必须再该节点之后访问
			path = append(path, cur.Val)

			if cur.Left != nil {
				q = append(q, cur.Left)
			}

			if cur.Right != nil {
				q = append(q, cur.Right)
			}

			dfs(q, path)

			q = q[0 : size-1]

			q = append(q, cur)

			path = path[:len(path)-1]
		}
	}

	dfs(q, []int{})

	return result
}
