package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 18:28
 */

func sortedArrayToBST(nums []int) *TreeNode {

	if len(nums) == 0 {
		return nil
	}

	var dfs func(nums []int, start, end int) *TreeNode
	dfs = func(nums []int, start, end int) *TreeNode {
		if start > end {
			return nil
		}
		mid := (start + end) / 2

		root := &TreeNode{
			Val: nums[mid],
		}

		root.Left = dfs(nums, start, mid-1)

		root.Right = dfs(nums, mid+1, end)

		return root

	}

	return dfs(nums, 0, len(nums)-1)
}
