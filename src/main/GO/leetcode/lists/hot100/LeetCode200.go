package hot100

func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0
	}
	var count = 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				numIslandsHelper(grid, i, j)
				count++
			}
		}
	}
	return count
}

func numIslandsHelper(grid [][]byte, i int, j int) {
	if i < 0 || i > len(grid)-1 || j < 0 || j > len(grid[0])-1 || grid[i][j] != '1' {
		return
	}
	grid[i][j] = '0'
	numIslandsHelper(grid, i+1, j)
	numIslandsHelper(grid, i, j+1)
	numIslandsHelper(grid, i-1, j)
	numIslandsHelper(grid, i, j-1)
}
