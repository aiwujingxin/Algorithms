package hot100

//DP： 打表后进行记忆化搜索，辅助以搜索空间
func maximalRectangle(matrix [][]byte) int {
	if len(matrix) == 0 {
		return 0
	}
	row, col := len(matrix), len(matrix[0])
	dp := make([][]int, row)
	for i := 0; i < row; i++ {
		dp[i] = make([]int, col)
	}
	maxArea := 0
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if i == 0 {
				if matrix[i][j] == '1' {
					dp[i][j] = 1
				}
			} else {
				if matrix[i][j] == '1' {
					dp[i][j] = dp[i-1][j] + 1
				}
			}
			min := dp[i][j]
			for k := j; k >= 0; k-- {
				if min == 0 {
					break
				}
				if dp[i][k] < min {
					min = dp[i][k]
				}
				maxArea = Max(maxArea, min*(j-k+1))
			}
		}
	}
	return maxArea
}
