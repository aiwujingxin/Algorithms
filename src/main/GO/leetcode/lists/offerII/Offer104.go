package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/28 20:06
 */

func combinationSum4(nums []int, target int) int {
	dp := make([]int, target+1)
	dp[0] = 1
	for i := 1; i <= target; i++ {
		for _, num := range nums {
			if num <= i {
				dp[i] += dp[i-num]
			}
		}

	}
	return dp[target]
}

func combinationSum4_DFS(nums []int, target int) int {
	if len(nums) == 0 {
		return 0
	}

	var dfs func(nums []int, target int) int

	dfs = func(nums []int, target int) int {
		if target == 0 {
			return 1
		}
		count := 0
		for i := 0; i < len(nums); i++ {
			if target >= nums[i] {
				count += dfs(nums, target-nums[i])
			}
		}
		return count
	}
	return dfs(nums, target)
}
