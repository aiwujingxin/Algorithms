package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/12 15:25
 */

func findSquare(matrix [][]int) []int {
	if len(matrix) == 0 {
		return []int{}
	}
	m := len(matrix)
	n := len(matrix[0])
	dp := make([][][2]int, m+1)
	for i := 0; i < m+1; i++ {
		dp[i] = make([][2]int, n+1)
	}
	for i := 0; i < m+1; i++ {
		for j := 0; j < n+1; j++ {
			dp[i][j] = [2]int{}
		}
	}
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if matrix[i-1][j-1] == 0 {
				dp[i][j][0] = 1 + dp[i][j-1][0]
				dp[i][j][1] = 1 + dp[i-1][j][1]
			}
		}
	}
	x, y, size := 0, 0, 0
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			for side := Min(dp[i][j][0], dp[i][j][1]); side >= 1; side-- {
				if dp[i][j-side+1][1] >= side && dp[i-side+1][j][0] >= side {
					if side > size {
						x = i - side
						y = j - side
						size = side
					}
				}
			}
		}
	}
	if size == 0 {
		return []int{}

	}
	return []int{x, y, size}
}
