package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/28 19:55
 */

func minFlipsMonoIncr(s string) int {

	if len(s) == 0 {
		return 0
	}
	dp := make([][]int, 2)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(s))
	}
	if s[0] == '0' {
		dp[0][0] = 0
	} else {
		dp[0][0] = 1
	}
	if s[0] == '1' {
		dp[1][0] = 0
	} else {
		dp[1][0] = 1
	}

	for i := 1; i < len(s); i++ {
		if s[i] == '0' {
			dp[0][i] = dp[0][i-1]
			dp[1][i] = Min(dp[0][i-1], dp[1][i-1]) + 1
		} else if s[i] == '1' {
			dp[0][i] = dp[0][i-1] + 1
			dp[1][i] = Min(dp[0][i-1], dp[1][i-1])
		}
	}
	return Min(dp[0][len(s)-1], dp[1][len(s)-1])
}
