package hot100

func maxProfit(prices []int) int {
	length := len(prices)
	if length == 0 {
		return 0
	}
	dp := make([][]int, length)
	for i := 0; i < length; i++ {
		dp[i] = make([]int, 2)
	}

	dp[0][0] = -prices[0]
	dp[0][1] = 0
	for i := 1; i < length; i++ {
		dp[i][0] = Max(dp[i-1][0], -prices[i])
		dp[i][1] = Max(dp[i-1][1], dp[i-1][0]+prices[i])
	}
	return dp[length-1][1]
}

func maxProfit_v2(prices []int) int {
	if len(prices) == 0 {
		return 0
	}
	var res, min = 0, prices[0]
	for i := 1; i < len(prices); i++ {
		if min < prices[i] {
			res = Max(res, prices[i]-min)
		} else {
			min = prices[i]
		}
	}
	return res
}
