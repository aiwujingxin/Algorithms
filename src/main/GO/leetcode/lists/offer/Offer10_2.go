package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 21:29
 */

func numWays(n int) int {

	if n == 0 {
		return 1
	}
	if n == 1 {
		return 1
	}
	if n == 2 {
		return 2
	}
	dp := make([]int, n+1)
	dp[0] = 0
	dp[1] = 1
	dp[2] = 2
	for i := 3; i <= n; i++ {
		dp[i] = (dp[i-1] + dp[i-2]) % 1000000007
	}
	return dp[len(dp)-1] % 1000000007
}
