package hot100

//[-2,1,-3,4,-1,2,1,-5,4]
func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	dp[0] = nums[0]
	res := nums[0]
	for i := 1; i < len(nums); i++ {
		dp[i] = Max(dp[i-1], 0) + nums[i]
		res = Max(dp[i], res)
	}
	return res
}
