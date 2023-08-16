package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/25 11:36
 */

func minimumTotal(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}
	dp := triangle[len(triangle)-1]
	for i := len(triangle) - 2; i >= 0; i-- {
		level := triangle[i]
		for j := 0; j < len(level); j++ {
			dp[j] = Min(dp[i], dp[i+1]) + level[j]
		}
	}
	return dp[0]
}
