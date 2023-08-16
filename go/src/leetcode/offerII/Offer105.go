package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 22:52
 */

func maxAreaOfIsland(grid [][]int) int {

	if len(grid) == 0 {
		return 0
	}
	res := 0
	visited := make([][]bool, len(grid))
	for i := 0; i < len(grid); i++ {
		visited[i] = make([]bool, len(grid[0]))
	}
	var dfs func(grid [][]int, i, j int) int

	dfs = func(grid [][]int, i, j int) int {
		if i < 0 || i >= len(grid) || j < 0 || j >= len(grid[0]) || grid[i][j] == 0 || visited[i][j] {
			return 0
		}
		visited[i][j] = true
		grid[i][j] = 0
		return 1 + dfs(grid, i+1, j) + dfs(grid, i, j+1) + dfs(grid, i-1, j) + dfs(grid, i, j-1)
	}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 1 {
				res = Max(res, dfs(grid, i, j))
			}
		}
	}
	return res
}
