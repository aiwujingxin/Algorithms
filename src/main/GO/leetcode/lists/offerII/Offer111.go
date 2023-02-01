package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/30 17:49
 */

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	if len(equations) == 0 {
		return []float64{}
	}
	graph := make(map[string]map[string]float64)
	buildGraph := func(equations [][]string, values []float64) {
		for i := 0; i < len(equations); i++ {
			first := equations[i][0]
			second := equations[i][1]
			if mp, ok := graph[first]; ok {
				mp[second] = values[i]
			} else {
				graph[first] = make(map[string]float64)
				graph[first][second] = values[i]
			}
			if mp, ok := graph[second]; ok {
				mp[first] = 1 / values[i]
			} else {
				graph[second] = make(map[string]float64)
				graph[second][first] = 1 / values[i]
			}
		}
	}
	var dfs func(graph map[string]map[string]float64, cur, end string, visited map[string]bool) float64
	dfs = func(graph map[string]map[string]float64, cur, end string, visited map[string]bool) float64 {
		if _, ok := graph[cur]; !ok {
			return -1
		}
		if v, ok := graph[cur][end]; ok {
			return v
		}
		visited[cur] = true

		for k, v := range graph[cur] {
			if !visited[k] {
				weight := dfs(graph, k, end, visited)
				if weight != -1 {
					return v * weight
				}
			}
		}
		return -1
	}
	buildGraph(equations, values)
	res := make([]float64, 0)
	for i := 0; i < len(queries); i++ {
		res = append(res, dfs(graph, queries[i][0], queries[i][1], map[string]bool{}))
	}
	return res
}
