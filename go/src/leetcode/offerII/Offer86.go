package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/29 22:22
 */

func partition86(s string) [][]string {

	if len(s) == 0 {
		return [][]string{}
	}

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
	res := make([][]string, 0)
	var dfs func(i int, temp []string)
	dfs = func(i int, temp []string) {
		if i == len(s) {
			res = append(res, append([]string(nil), temp...))
			return
		}
		for j := i; j < len(s); j++ {
			if dp[i][j] {
				temp = append(temp, s[i:j+1])
				dfs(j+1, temp)
				temp = temp[:len(temp)-1]
			}
		}
	}
	dfs(0, []string{})
	return res
}
