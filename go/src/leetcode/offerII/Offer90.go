package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 22:31
 */

func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	var rob func(nums []int) int
	rob = func(nums []int) int {
		if len(nums) == 0 {
			return 0
		}
		if len(nums) == 1 {
			return nums[0]
		}
		dp := make([]int, len(nums))
		dp[0] = nums[0]
		dp[1] = Max(nums[0], nums[1])
		for i := 2; i < len(dp); i++ {
			dp[i] = Max(dp[i-1], dp[i-2]+nums[i])
		}
		return dp[len(dp)-1]
	}
	return Max(rob(nums[1:]), rob(nums[:len(nums)-1]))
}
