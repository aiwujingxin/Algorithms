package hot100

func isMatch(s string, p string) bool {
	var dfs func(s string, si int, p string, pi int) bool
	dfs = func(s string, si int, p string, pi int) bool {
		if pi < 0 {
			return si < 0
		}
		if si < 0 {
			return (p[pi] == '*') && dfs(s, si, p, pi-2)
		}
		if s[si] == p[pi] || p[pi] == '.' {
			return dfs(s, si-1, p, pi-1)
		}
		if p[pi] == '*' {
			if p[pi-1] == s[si] || p[pi-1] == '.' {
				return dfs(s, si-1, p, pi) || dfs(s, si, p, pi-2)
			}
			return dfs(s, si, p, pi-2)
		}
		return false
	}
	return dfs(s, len(s)-1, p, len(p)-1)
}
