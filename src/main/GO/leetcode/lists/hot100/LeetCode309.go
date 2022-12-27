package hot100

func maxProfit309(prices []int) int {
	if len(prices) == 0 {
		return 0
	}
	dp := make([][]int, len(prices))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2)
	}
	dp[0][0] = 0          //未持有
	dp[0][1] = -prices[0] //持有
	dp[0][2] = 0          //未持有,但是在冷冻期
	for i := 1; i < len(prices); i++ {
		dp[i][0] = Max(dp[i-1][0], dp[i-1][2])
		dp[i][1] = Max(dp[i-1][0]-prices[i], dp[i-1][1])
		dp[i][2] = dp[i-1][1] + prices[i]
	}
	return Max(dp[len(prices)-1][0], dp[len(prices)-1][2])
}
