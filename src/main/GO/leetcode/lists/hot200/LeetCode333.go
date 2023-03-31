package hot200

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/16 17:13
 */

func largestBSTSubtree(root *TreeNode) (ans int) {
	var dfs func(node *TreeNode) (bool, int, int, int) // 是否搜索树 总节点数量 最小节点值 最大节点值
	dfs = func(node *TreeNode) (bool, int, int, int) {
		if node == nil {
			return true, 0, math.MaxInt, math.MinInt
		}
		left, leftCnt, leftMin, leftMax := dfs(node.Left)
		right, rightCnt, rightMin, rightMax := dfs(node.Right)
		cur := left && right && node.Val > leftMax && node.Val < rightMin
		curCnt := leftCnt + rightCnt + 1
		// curMin curMax 的作用？
		curMin := Min(node.Val, Min(leftMin, rightMin))
		curMax := Max(node.Val, Max(leftMax, rightMax))
		if cur {
			ans = Max(ans, curCnt)
		}
		return cur, curCnt, curMin, curMax
	}
	dfs(root)
	return
}
