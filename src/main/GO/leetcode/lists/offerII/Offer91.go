package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/29 22:17
 */

func minCost(costs [][]int) int {

	if len(costs) == 0 {
		return 0
	}
	dp := make([][]int, len(costs))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 3)
	}
	dp[0][0] = costs[0][0]
	dp[0][1] = costs[0][1]
	dp[0][2] = costs[0][2]

	for i := 1; i < len(costs); i++ {
		dp[i][0] = Min(dp[i-1][1]+costs[i][0], dp[i-1][2]+costs[i][0])
		dp[i][1] = Min(dp[i-1][0]+costs[i][1], dp[i-1][2]+costs[i][1])
		dp[i][2] = Min(dp[i-1][0]+costs[i][2], dp[i-1][1]+costs[i][2])
	}
	return Min(Min(dp[len(costs)-1][0], dp[len(costs)-1][1]), Min(dp[len(costs)-1][0], dp[len(costs)-1][2]))
}
