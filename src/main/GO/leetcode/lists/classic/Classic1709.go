package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 22:16
 */

func getKthMagicNumber(k int) int {
	dp := make([]int, k+1)
	dp[1] = 1
	p3, p5, p7 := 1, 1, 1
	for i := 2; i <= k; i++ {
		x2, x3, x5 := dp[p3]*3, dp[p5]*5, dp[p7]*7
		dp[i] = Min(Min(x2, x3), x5)
		if dp[i] == x2 {
			p3++
		}
		if dp[i] == x3 {
			p5++
		}
		if dp[i] == x5 {
			p7++
		}
	}
	return dp[k]
}
