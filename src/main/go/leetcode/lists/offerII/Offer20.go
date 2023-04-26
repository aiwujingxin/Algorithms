package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 18:34
 */

func countSubstrings(s string) int {
	if len(s) == 0 {
		return 0
	}
	dp := make([][]int, len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = make([]int, len(s))
	}
	count := 0
	for i := len(s) - 1; i >= 0; i-- {
		for j := i; j < len(s); j++ {
			if i == j {
				dp[i][j] = 1
			} else {
				if s[i] == s[j] {
					if dp[i+1][j-1] > 0 || (j-i == 1) {
						dp[i][j] = 2 + dp[i+1][j-1]
					}
				}
			}
			if dp[i][j] > 0 {
				count++
			}
		}
	}
	return count
}
