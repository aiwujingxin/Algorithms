package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/6 18:39
 */

func findWhetherExistsPath(n int, graph [][]int, start int, target int) bool {
	g := make([]map[int]bool, n)
	for i := 0; i < n; i++ {
		g[i] = make(map[int]bool)
	}
	for _, edge := range graph {
		if edge[0] != edge[1] {
			g[edge[0]][edge[1]] = true
		}
	}
	q := make([]int, 0)
	q = append(q, start)
	visit := make([]bool, n)
	for len(q) > 0 {
		cur := q[0]
		q = q[1:]
		if visit[cur] {
			continue
		}
		visit[cur] = true
		if cur == target {
			return true
		}
		for k := range g[cur] {
			if !visit[k] {
				q = append(q, k)
			}
		}
	}
	return false
}
