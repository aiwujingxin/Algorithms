package hot100

//https://blog.csdn.net/oinux125/article/details/106762105

//case:
//"(()())"
//"((()))())"
//")))))(((()("
func longestValidParentheses(s string) int {
	//记忆化搜索
	if len(s) == 0 {
		return 0
	}
	dp, res := make([]int, len(s)), 0
	dp[0] = 0
	for i := 1; i < len(s); i++ {
		ch := s[i]
		if ch == ')' {
			index := i - 1
			if s[index] == '(' {
				dp[i] = 2
			} else {
				for index >= 0 && dp[index] > 0 && s[index] == ')' {
					index = index - dp[index]
				}
				if index >= 0 && s[index] == '(' {
					dp[i] = i - index + 1
				}
			}
		}
	}
	for i := len(dp) - 1; i > 0; i-- {
		if dp[i] > 0 {
			temp := dp[i]
			index := i - dp[i]
			for index > 0 && dp[index] > 0 {
				temp = temp + dp[index]
				index = index - dp[index]
			}
			res = Max(res, temp)
		}
	}
	return res
}
