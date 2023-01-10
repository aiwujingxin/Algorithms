package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 14:53
 */

func pathSum(root *TreeNode, target int) [][]int {
	if root == nil {
		return [][]int{}
	}
	list := make([][]int, 0)
	var dfs func(root *TreeNode, target int, temp []int)
	dfs = func(root *TreeNode, target int, temp []int) {
		if root == nil {
			return
		}
		if target-root.Val == 0 && root.Right == nil && root.Left == nil {
			temp = append(temp, root.Val)
			list = append(list, append([]int(nil), temp...))
			return
		} else {
			dfs(root.Right, target-root.Val, append(temp, root.Val))
			dfs(root.Left, target-root.Val, append(temp, root.Val))
		}
	}
	dfs(root, target, make([]int, 0))
	return list
}
