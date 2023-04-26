package hot100

//https://leetcode.com/problems/perfect-squares/solutions/337921/go-o-n-3-2-dp/

//https://leetcode.cn/problems/perfect-squares/solution/gong-shui-san-xie-xiang-jie-wan-quan-bei-nqes/
func numSquares(n int) int {
	if n == 0 {
		return 0
	}
	dp := make([]int, n+1)
	for i := 1; i <= n; i++ {
		dp[i] = i
		for j := 0; j*j <= i; j++ {
			dp[i] = Min(dp[i], dp[i-j*j]+1)
		}
	}
	return dp[n]
}
