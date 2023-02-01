package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 13:15
 */

func maximalRectangle(matrix []string) int {
	if len(matrix) == 0 {
		return 0
	}
	//init
	dp := make([][]int, len(matrix))
	for i := 0; i < len(matrix); i++ {
		dp[i] = make([]int, len(matrix[0]))
	}
	for col := 0; col < len(matrix[0]); col++ {
		if matrix[0][col] == '1' {
			dp[0][col] = 1
		}
	}
	for row := 1; row < len(matrix); row++ {
		for col := 0; col < len(matrix[0]); col++ {
			if matrix[row][col] == '1' {
				dp[row][col] = dp[row-1][col] + 1
			}
		}
	}
	max := 0
	for i := 0; i < len(dp); i++ {
		for j := len(dp[0]) - 1; j >= 0; j-- {
			if dp[i][j] == 0 {
				continue
			}
			tm := dp[i][j]
			left := j
			for left >= 0 {
				if dp[i][left] == 0 {
					break
				}
				if dp[i][left] < tm {
					tm = dp[i][left]
				}
				max = Max(max, (j-left+1)*tm)
				left--
			}
		}
	}
	return max
}
