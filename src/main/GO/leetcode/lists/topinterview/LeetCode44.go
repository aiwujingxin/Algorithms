package topinterview

import "math"

//https://leetcode.com/problems/wildcard-matching/solutions/1625997/gk-s-python-solution-recursive-dfs-iterative-dp/
func isMatch(s string, p string) bool {

	dp := make([][]int, len(s)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(p)+1)
	}
	for i := 0; i < len(dp); i++ {
		for j := 0; j < len(dp[0]); j++ {
			dp[i][j] = math.MinInt32
		}
	}
	var dfs func(s string, si int, p string, pi int) bool
	dfs = func(s string, si int, p string, pi int) bool {
		if dp[si][pi] != math.MinInt32 {
			return dp[si][pi] == 1
		}
		if si >= len(s) {
			if pi >= len(p) {
				dp[si][pi] = 1
				return true
			}
			for i := pi; i < len(p); i++ {
				if p[i] != '*' {
					dp[si][pi] = -1
					return false
				}
			}
			dp[si][pi] = 1
			return true
		}
		if pi >= len(p) {
			dp[si][pi] = -1
			return false
		}
		if s[si] == p[pi] || p[pi] == '?' {
			res := dfs(s, si+1, p, pi+1)
			if res {
				dp[si][pi] = 1
			} else {
				dp[si][pi] = -1
			}
			return res
		}
		if p[pi] == '*' {
			res := dfs(s, si+1, p, pi) || dfs(s, si, p, pi+1)
			if res {
				dp[si][pi] = 1
			} else {
				dp[si][pi] = -1
			}
			return res
		}
		dp[si][pi] = -1
		return false
	}
	return dfs(s, 0, p, 0)
}
