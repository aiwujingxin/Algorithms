package hot100

func lengthOfLIS(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	res := 1
	for i := 0; i < len(nums); i++ {
		temp := 0
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				temp = Max(temp, dp[j])
			}
		}
		dp[i] = temp + 1
		res = Max(res, dp[i])
	}
	return res
}
