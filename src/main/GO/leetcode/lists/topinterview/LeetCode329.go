package topinterview

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/solutions/2054922/java-3-approaches-dfs-bfs-memoization-dfs/
//https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/solution/tong-ge-lai-shua-ti-la-yi-ti-si-jie-bfs-agawl/

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/solutions/775043/both-dfs-and-bfs-solutions/

var dir = [][]int{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}

func longestIncreasingPath(matrix [][]int) int {
	if len(matrix) == 0 {
		return 0
	}
	res := 0
	indegree := make([][]int, len(matrix))
	for i := 0; i < len(indegree); i++ {
		indegree[i] = make([]int, len(matrix[0]))
	}
	q := make([][]int, 0)

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			indegreeCount := 0
			for k := 0; k < 4; k++ {
				r := i + dir[k][0]
				c := j + dir[k][1]
				if r >= 0 && c >= 0 && r < len(matrix) && c < len(matrix[0]) && matrix[r][c] < matrix[i][j] {
					indegreeCount++
				}
			}
			indegree[i][j] = indegreeCount
			if indegree[i][j] == 0 {
				q = append(q, []int{i, j, 1})

			}
		}
	}
	for len(q) > 0 {
		node := q[0]
		q = q[1:]
		x := node[0]
		y := node[1]
		step := node[2]
		res = Max(res, step)
		for k := 0; k < 4; k++ {
			r := x + dir[k][0]
			c := y + dir[k][1]
			if r >= 0 && c >= 0 && r < len(matrix) && c < len(matrix[0]) && matrix[r][c] > matrix[x][y] {
				indegree[r][c]--
				if indegree[r][c] == 0 {
					q = append(q, []int{r, c, step + 1})

				}
			}
		}
	}
	return res
}
