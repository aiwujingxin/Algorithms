package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 19:05
 */

func verifyPostorder(postorder []int) bool {

	if len(postorder) == 0 {
		return true
	}

	var dfs func(postorder []int, start int, end int) bool
	dfs = func(postorder []int, start int, end int) bool {
		if start >= end {
			return true
		}
		left := start
		for left < end && postorder[left] < postorder[end] {
			left++
		}
		right := left
		for right < end && postorder[right] > postorder[end] {
			right++
		}
		return right == end && dfs(postorder, start, left-1) && dfs(postorder, left, end-1)
	}
	return dfs(postorder, 0, len(postorder)-1)
}
