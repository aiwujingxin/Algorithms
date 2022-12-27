package hot100

func maximalSquare(matrix [][]byte) int {
	if len(matrix) == 0 {
		return 0
	}
	dp := make([][]int, len(matrix))
	for i := 0; i < len(matrix); i++ {
		dp[i] = make([]int, len(matrix[0]))
	}
	var side = 0
	for i := 0; i < len(matrix[0]); i++ {
		if matrix[0][i] == '1' {
			dp[0][i] = 1
			side = 1
		}
	}
	for i := 0; i < len(matrix); i++ {
		if matrix[i][0] == '1' {
			dp[i][0] = 1
			side = 1
		}
	}
	for i := 1; i < len(matrix); i++ {
		for j := 1; j < len(matrix[0]); j++ {
			if matrix[i][j] == '1' {
				dp[i][j] = Min(Min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1
			}
			side = Max(side, dp[i][j])
		}
	}
	return side * side
}
