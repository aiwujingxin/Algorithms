package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/29 20:48
 */

// 注意错误的提交
func isBipartite(graph [][]int) bool {
	if len(graph) == 0 {
		return true
	}
	color := make([]int, len(graph))
	bfs := func(cur int) bool {
		q := make([]int, 0)
		q = append(q, cur)
		color[cur] = 1
		for len(q) > 0 {
			cur := q[0]
			q = q[1:]
			for _, neighbor := range graph[cur] {
				if color[neighbor] != 0 {
					if color[neighbor] == color[cur] {
						return false
					}
				} else {
					color[neighbor] = -color[cur]
					q = append(q, neighbor)
				}
			}
		}
		return true
	}
	for i := 0; i < len(graph); i++ {
		if color[i] != 0 {
			continue
		}
		if !bfs(i) {
			return false
		}
	}
	return true
}

/*[[4,1],[0,2],[1,3],[2,4],[3,0]]
func isBipartite_WA(graph [][]int) bool {
	if len(graph) == 0 {
		return true
	}
	color := make([]int, len(graph))
	q := make([]int, 0)
	q = append(q, 0)
	color[0] = 1
	for len(q) > 0 {
		node := q[0]
		q = q[1:]
		for n := 0; n < len(graph[node]); n++ {
			if color[n] != 0 {
				if color[n] == color[node] {
					return false
				}
			} else {
				color[n] = -color[node]
				q = append(q, n)
			}
		}
	}
	return true
}
*/
