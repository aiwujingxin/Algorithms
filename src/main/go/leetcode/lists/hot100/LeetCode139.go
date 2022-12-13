package hot100

func wordBreak(s string, wordDict []string) bool {
	if len(wordDict) == 0 {
		return false
	}
	mp := make(map[string]bool)
	for _, w := range wordDict {
		mp[w] = true
	}
	dp := make([]bool, len(s)+1)
	dp[0] = true
	for i := 0; i <= len(s); i++ {
		for j := 0; j < i; j++ {
			if dp[j] && mp[s[j+1:i]] {
				dp[i] = true
				break
			}
		}
	}
	return dp[len(s)]
}
