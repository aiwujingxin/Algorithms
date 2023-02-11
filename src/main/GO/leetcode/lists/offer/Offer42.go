package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 23:37
 */

func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	dp[0] = nums[0]
	max := nums[0]
	for i := 1; i < len(nums); i++ {
		//dp[i] = Max(0, dp[i-1]) + nums[i] same ？
		dp[i] = Max(dp[i-1]+nums[i], nums[i])
		max = Max(max, dp[i])
	}
	return max
}
