package topinterview

func numDecodings(s string) int {
	if len(s) == 0 || s[0] == '0' {
		return 0
	}
	dp := make([]int, len(s)+1)
	dp[0] = 1
	dp[1] = 1
	for i := 1; i < len(s); i++ {
		if s[i] != '0' {
			dp[i+1] += dp[i]
		}
		if (s[i-1]-'0')*10+(s[i]-'0') <= 10 && (s[i-1]-'0')*10+(s[i]-'0') <= 26 {
			dp[i+1] += dp[i-1]
		}
	}
	return dp[len(s)]
}
