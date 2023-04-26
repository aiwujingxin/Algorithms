package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/7 21:41
 */

func generateParenthesis(n int) []string {
	res := make([]string, 0)
	var dfs func(left, right int, temp string)
	dfs = func(left, right int, temp string) {
		if len(temp) == n*2 {
			res = append(res, temp)
			return
		}
		if left < n {
			dfs(left+1, right, temp+"(")
		}

		if right < left {
			dfs(left, right+1, temp+")")
		}
	}
	dfs(0, 0, "")
	return res
}
