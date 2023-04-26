package hot100

//https://leetcode.com/problems/evaluate-division/solutions/1919266/go-golang-floyd-warshall-time-o-n-3-0-ms-100-space-o-n-2-2-mb-80-91/
func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	dist := make(map[string]map[string]float64)
	for i, e := range equations {
		from, to := e[0], e[1]

		if dist[from] == nil {
			dist[from] = make(map[string]float64)
		}
		if dist[to] == nil {
			dist[to] = make(map[string]float64)
		}
		dist[from][to] = values[i]
		dist[to][from] = 1 / values[i]
		dist[from][from], dist[to][to] = 1, 1
	}
	for k, d := range dist {
		for k1 := range d {
			for k2 := range d {
				dist[k1][k2] = dist[k1][k] * dist[k][k2]
			}
		}
	}

	var result []float64
	for _, q := range queries {
		from, to := q[0], q[1]
		_, okFrom := dist[from]
		_, okTo := dist[to]

		if okFrom && okTo && dist[from][to] > 0 {
			result = append(result, dist[from][to])
		} else {
			result = append(result, -1)
		}
	}

	return result
}
