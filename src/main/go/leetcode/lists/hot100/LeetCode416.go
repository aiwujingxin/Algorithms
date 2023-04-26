package hot100

func canPartition(nums []int) bool {
	if len(nums) == 0 {
		return true
	}
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
	}
	if sum%2 != 0 {
		return false
	}
	target := sum / 2
	dp := make([]bool, target+1)
	dp[0] = true
	for _, nu := range nums {
		for i := target; i > 0; i-- {
			if i-nu >= 0 {
				dp[i] = dp[i] || dp[i-nu]
			}
		}
	}
	return dp[target]
}
