package classic

import "sort"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/9 16:53
 */

func pondSizes(land [][]int) []int {

	if len(land) == 0 {
		return []int{}
	}

	res := make([]int, 0)

	var dfs func(i, j int) int
	dfs = func(i, j int) int {
		if i < 0 || i >= len(land) || j < 0 || j >= len(land[0]) || land[i][j] != 0 {
			return 0
		}
		land[i][j] = -1
		return 1 + dfs(i+1, j) + dfs(i, j+1) + dfs(i-1, j) + dfs(i, j-1) +
			dfs(i+1, j+1) + dfs(i+1, j-1) + dfs(i-1, j-1) + dfs(i-1, j+1)
	}
	for i := 0; i < len(land); i++ {
		for j := 0; j < len(land[0]); j++ {
			if land[i][j] == 0 {
				res = append(res, dfs(i, j))
			}
		}
	}
	sort.Ints(res)
	return res
}
