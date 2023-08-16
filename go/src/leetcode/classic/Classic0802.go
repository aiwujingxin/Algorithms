package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 17:43
 */

func pathWithObstacles(obstacleGrid [][]int) [][]int {

	if len(obstacleGrid) == 0 {
		return [][]int{}
	}

	rows := len(obstacleGrid)
	cols := len(obstacleGrid[0])
	dp := make([][]bool, rows)
	for i := 0; i < rows; i++ {
		dp[i] = make([]bool, cols)
	}
	dp[0][0] = obstacleGrid[0][0] == 0
	// 边界情况单独处理
	for i := 1; i < rows; i++ {
		if obstacleGrid[i][0] == 0 {
			dp[i][0] = dp[i-1][0]
		}
	}
	// 边界情况单独处理
	for j := 1; j < cols; j++ {
		if obstacleGrid[0][j] == 0 {
			dp[0][j] = dp[0][j-1]
		}
	}
	// 因为题目要求只能走下或走右，所以(i, j)是否可达取决于(i-1, j)或者(i, j-1)是否可达
	for i := 1; i < rows; i++ {
		for j := 1; j < cols; j++ {
			if obstacleGrid[i][j] == 0 {
				dp[i][j] = dp[i-1][j] || dp[i][j-1]
			}
		}
	}
	if !dp[rows-1][cols-1] {
		return [][]int{}
	}
	path := make([][]int, rows+cols-1)
	idx := len(path) - 1
	// 从终点开始倒推路径
	path[idx] = []int{rows - 1, cols - 1}
	idx--
	// 倒推方向为向左或向上
	dirs := [][]int{{-1, 0}, {0, -1}}
	for idx >= 0 {
		lastCell := path[idx+1]
		for _, d := range dirs {
			nextX := lastCell[0] + d[0]
			nextY := lastCell[1] + d[1]
			if nextX >= 0 && nextY >= 0 && dp[nextX][nextY] {
				path[idx] = []int{nextX, nextY}
				break
			}
		}
		idx--
	}
	return path
}
