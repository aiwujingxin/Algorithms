package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/28 22:34
 */

func findTargetSumWays(nums []int, target int) int {
	if len(nums) == 0 {
		return 0
	}
	sum := 0
	for _, num := range nums {
		sum += num
	}
	if sum < target || (target+sum)%2 == 1 {
		return 0
	}
	a := (target + sum) / 2
	dp := make([]int, a+1)
	dp[0] = 1

	for _, num := range nums {
		for j := a; j >= 0; j-- {
			if j >= num {
				dp[j] += dp[j-num]
			}
		}
	}
	return dp[len(dp)-1]
}
