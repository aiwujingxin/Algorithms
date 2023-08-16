package hot100

func coinChange(coins []int, amount int) int {
	if len(coins) == 0 {
		return 0
	}
	dp := make([]int, amount+1)
	ma := amount + 1

	for i := 0; i < len(dp); i++ {
		dp[i] = ma
	}
	dp[0] = 0
	for i := 1; i <= amount; i++ {
		for _, coin := range coins {
			if coin <= i {
				dp[i] = Min(dp[i], dp[i-coin]+1)
			}
		}
	}
	if dp[amount] == ma {
		return -1
	}
	return dp[amount]
}
