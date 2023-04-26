package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/2 21:42
 */

func waysToStep(n int) int {
	if n == 1 || n == 2 {
		return n
	} else if n == 3 {
		return 4
	}

	dp := make([]int, n+1)
	dp[1] = 1
	dp[2] = 2
	dp[3] = 4

	for i := 4; i <= n; i++ {
		dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000007
	}
	return dp[n]
}
