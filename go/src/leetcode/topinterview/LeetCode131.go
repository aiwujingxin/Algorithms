package topinterview

func partition(s string) [][]string {
	if len(s) == 0 {
		return [][]string{}
	}
	dp := make([][]bool, len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = make([]bool, len(s))
	}
	for i := 0; i < len(dp); i++ {
		for j := 0; j < len(dp[0]); j++ {
			dp[i][j] = true
		}
	}
	for i := len(s) - 1; i >= 0; i-- {
		for j := i + 1; j < len(s); j++ {
			dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
		}
	}
	res := make([][]string, 0)
	var dfs func(s string, index int, list []string)
	dfs = func(s string, i int, list []string) {
		if i == len(s) {
			res = append(res, append([]string(nil), list...))
			return
		}
		for j := i; j < len(s); j++ {
			if dp[i][j] {
				list = append(list, s[i:j+1])
				dfs(s, j+1, list)
				list = list[:len(list)-1]
			}
		}
	}
	dfs(s, 0, []string{})
	return res
}
