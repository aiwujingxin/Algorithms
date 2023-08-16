package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/28 20:23
 */

func coinChange(coins []int, amount int) int {
	if len(coins) == 0 {
		return -1
	}
	if amount == 0 {
		return 0
	}

	dp := make([]int, amount+1)

	for i := 0; i < len(dp); i++ {
		dp[i] = amount + 1
	}

	for _, coin := range coins {
		for i := 0; i < amount; i++ {
			if coin >= i {
				dp[i] = Min(dp[i-coin]+1, dp[i])
			}
		}
	}
	if dp[len(dp)-1] == amount+1 {
		return -1
	}
	return dp[len(dp)-1]
}
