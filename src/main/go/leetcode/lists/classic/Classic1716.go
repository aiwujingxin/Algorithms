package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 22:20
 */

func massage(nums []int) int {
	l := len(nums)
	if l == 0 {
		return 0
	}
	if l == 1 {
		return nums[0]
	}

	dp := make([]int, l)
	dp[0] = nums[0]
	dp[1] = Max(nums[0], nums[1])

	for i := 2; i < l; i++ {
		dp[i] = Max(dp[i-1], dp[i-2]+nums[i])
	}
	return dp[l-1]
}
