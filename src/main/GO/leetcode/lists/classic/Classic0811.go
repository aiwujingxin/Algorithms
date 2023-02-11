package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 18:05
 */

func waysToChange(n int) int {
	if n == 0 {
		return 0
	}
	coins := []int{1, 5, 10, 25}
	dp := make([]int, n+1)
	dp[0] = 1
	dp[1] = 1
	for _, coin := range coins {
		for i := 2; i <= n; i++ {
			if i >= coin {
				dp[i] = dp[i-coin] + dp[i]
			}
		}
	}
	return dp[len(dp)-1] % 1000000007
}
