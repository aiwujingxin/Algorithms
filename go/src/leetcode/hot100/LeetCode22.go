package hot100

func generateParenthesis(n int) []string {
	if n == 0 {
		return []string{}
	}
	var res []string
	var dfs func(left, right, n int, s string)
	dfs = func(left, right, n int, s string) {
		if len(s) == n*2 {
			res = append(res, s)
			return
		}
		if left < n {
			dfs(left+1, right, n, s+"(")
		}
		if right < left {
			dfs(left, right+1, n, s+")")
		}
	}
	dfs(0, 0, n, "")
	return res
}
