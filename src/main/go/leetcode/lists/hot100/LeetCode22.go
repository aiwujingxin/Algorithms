package hot100

func generateParenthesis(n int) []string {
	if n == 0 {
		return []string{}
	}
	var res []string
	generateParenthesisHelper(&res, 0, 0, n, "")
	return res
}

func generateParenthesisHelper(res *[]string, left, right, n int, s string) {
	if len(s) == n*2 {
		*res = append(*res, s)
		return
	}
	if left < n {
		generateParenthesisHelper(res, left+1, right, n, s+"(")
	}
	if right < left {
		generateParenthesisHelper(res, left, right+1, n, s+")")
	}
}
