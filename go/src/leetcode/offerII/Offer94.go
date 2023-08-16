package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/30 15:54
 */

func minCut(s string) int {
	n := len(s)
	dp := make([][]bool, len(s))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, len(s))
	}

	for i := 0; i < len(dp); i++ {
		dp[i][i] = true
	}

	for i := len(s) - 2; i >= 0; i-- {
		for j := 1; j < len(s); j++ {
			if s[i] == s[j] && dp[i+1][j-1] {
				dp[i][j] = true
			} else if s[i] == s[j] && j-i == 1 {
				dp[i][j] = true
			}
		}
	}
	f := make([]int, n)
	for i := range f {
		if dp[0][i] {
			continue
		}
		f[i] = math.MaxInt64
		for j := 0; j < i; j++ {
			if dp[j+1][i] && f[j]+1 < f[i] {
				f[i] = f[j] + 1
			}
		}
	}
	return f[n-1]
}
