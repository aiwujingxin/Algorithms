package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 15:35
 */

func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
	visited := make([][]bool, len(image))
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, len(image[0]))
	}
	color := image[sr][sc]
	var dfs func(i, j int)
	dfs = func(i, j int) {
		if i < 0 || i >= len(image) || j < 0 || j >= len(image[0]) || visited[i][j] || image[i][j] != color {
			return
		}
		image[i][j] = newColor
		visited[i][j] = true
		dfs(i+1, j)
		dfs(i, j+1)
		dfs(i-1, j)
		dfs(i, j-1)
	}
	dfs(sr, sc)
	return image
}
