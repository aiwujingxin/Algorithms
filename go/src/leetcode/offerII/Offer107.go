package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/29 20:58
 */

func updateMatrix(mat [][]int) [][]int {
	if len(mat) == 0 {
		return [][]int{}
	}
	dist := make([][]int, len(mat))
	for i := 0; i < len(mat); i++ {
		dist[i] = make([]int, len(mat[0]))
	}
	seen := make([][]bool, len(mat))
	for i := 0; i < len(mat); i++ {
		seen[i] = make([]bool, len(mat[0]))
	}
	q := make([][]int, 0)
	for i := 0; i < len(mat); i++ {
		for j := 0; j < len(mat[0]); j++ {
			if mat[i][j] == 0 {
				q = append(q, []int{i, j})
				seen[i][j] = true
			}
		}
	}
	dirs := [][]int{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}
	for len(q) > 0 {
		cell := q[0]
		q = q[1:]
		for i := 0; i < len(dirs); i++ {
			ni := cell[0] + dirs[i][0]
			nj := cell[1] + dirs[i][1]
			if ni >= 0 && ni < len(mat) && nj >= 0 && nj < len(mat[0]) && !seen[ni][nj] {
				dist[ni][nj] = dist[cell[0]][cell[1]] + 1
				q = append(q, []int{ni, nj})
				seen[ni][nj] = true
			}
		}
	}
	return dist
}
