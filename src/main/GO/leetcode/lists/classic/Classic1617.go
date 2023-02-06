package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 17:09
 */

func maxSubArray(nums []int) int {

	if len(nums) == 0 {
		return 0
	}

	dp := make([]int, len(nums))
	dp[0] = nums[0]
	max := nums[0]
	for i := 1; i < len(nums); i++ {
		dp[i] = Max(dp[i-1], 0) + nums[i]
		max = Max(max, dp[i])
	}

	return max
}
