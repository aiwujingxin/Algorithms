package hot100

func countSubstrings(s string) int {
	if len(s) == 0 {
		return 0
	}
	dp := make([][]int, len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = make([]int, len(s))
	}
	var res int
	for i := len(s) - 1; i >= 0; i-- {
		//为什么不从0开始? 因为dp[i][j] j>=i 才有意义
		//所以最重要的还是状态转移方程
		//状态转移方程能决定遍历的顺序，以及遍历的开始点和结束点
		for j := i; j < len(s); j++ {
			if i == j {
				dp[i][j] = 1
			} else {
				if s[i] == s[j] {
					if dp[i+1][j-1] > 0 || (j-i == 1) {
						dp[i][j] = dp[i+1][j-1] + 2
					}
				}
			}
			if dp[i][j] > 0 {
				res++
			}
		}
	}
	return res
}
