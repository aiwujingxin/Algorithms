package classic

import "strings"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/15 18:13
 */

func solveNQueens(n int) [][]string {
	res := make([][]string, 0)
	valid := func(grid [][]string, x, y int) bool {
		for i := 0; i < n; i++ {
			for j := 0; j < n; j++ {
				if grid[i][j] == "Q" {
					if x == i || y == j || x+y == i+j || x-y == i-j {
						return false
					}
				}
			}
		}
		return true
	}
	t := func(grid [][]string) []string {
		list := make([]string, 0)
		for i := 0; i < len(grid); i++ {
			list = append(list, strings.Join(grid[i], ""))
		}
		return list
	}
	var dfs func(grid [][]string, row int)
	dfs = func(grid [][]string, row int) {
		if row == n {
			res = append(res, t(grid))
			return
		}
		for col := 0; col < n; col++ {
			if !valid(grid, row, col) {
				continue
			}
			grid[row][col] = "Q"
			dfs(grid, row+1)
			grid[row][col] = "."
		}
	}

	grid := make([][]string, n)
	for i := 0; i < n; i++ {
		grid[i] = make([]string, n)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			grid[i][j] = "."
		}
	}
	for row := 0; row < n; row++ {
		dfs(grid, row)
	}
	return res
}
