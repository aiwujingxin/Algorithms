package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/25 12:05
 */

func minPathSum(grid [][]int) int {

	if len(grid) == 0 {
		return 0
	}
	dp := make([][]int, len(grid))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(grid[0]))
	}
	dp[0][0] = grid[0][0]
	for col := 1; col < len(grid[0]); col++ {
		dp[0][col] = dp[0][col-1] + grid[0][col]
	}
	for row := 1; row < len(grid); row++ {
		dp[row][0] = dp[row-1][0] + grid[row][0]
	}
	for i := 1; i < len(grid); i++ {
		for j := 1; j < len(grid[0]); j++ {
			dp[i][j] = Min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}
	return dp[len(dp)-1][len(dp[0])-1]
}
