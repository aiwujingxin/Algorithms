package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/30 16:01
 */

func numDistinct(s string, t string) int {
	if len(s) < len(t) {
		return 0
	}
	dp := make([][]int, len(t)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(s)+1)
	}
	for i := 0; i < len(dp[0]); i++ {
		dp[0][i] = 1
	}
	for i := 1; i <= len(t); i++ {
		for j := 1; j <= len(s); j++ {
			if t[i-1] == s[j-1] {
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
			} else {
				dp[i][j] = dp[i][j-1]
			}
		}
	}
	return dp[len(dp)-1][len(dp[0])-1]
}
