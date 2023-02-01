package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 16:44
 */

func generateParenthesis(n int) []string {

	if n == 0 {
		return []string{}
	}
	res := make([]string, 0)
	var dfs func(left, right, n int, t string)
	dfs = func(left, right, n int, t string) {
		if len(t) == n*2 {
			res = append(res, t)
			return
		}
		if left < n {
			dfs(left+1, right, n, t+"(")
		}
		if right < left {
			dfs(left, right+1, n, t+")")
		}
	}
	dfs(0, 0, n, "")
	return res
}
