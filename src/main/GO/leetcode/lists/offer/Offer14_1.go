package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 21:49
 */

func cuttingRope(n int) int {
	if n == 2 {
		return 1
	}
	if n == 3 {
		return 2
	}
	dp := make([]int, n+1)
	dp[0] = 0
	dp[1] = 1
	dp[2] = 2
	dp[3] = 3
	max := 0
	for i := 3; i <= n; i++ {
		for j := 1; j <= i/2; j++ {
			dp[i] = Max(dp[i], dp[j]*dp[i-j])
		}
		max = Max(max, dp[i])
	}
	return max
}
