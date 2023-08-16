package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/31 23:15
 */

func findRedundantConnection(edges [][]int) []int {
	if len(edges) == 0 {
		return []int{}
	}
	// 如何判断两个节点是否属于同一个子图
	// 合并两个子图
	maxVertex := 0

	for _, edge := range edges {
		maxVertex = Max(maxVertex, edge[0])
		maxVertex = Max(maxVertex, edge[1])
	}
	parent := make([]int, maxVertex+1)
	for i := 1; i <= maxVertex; i++ {
		parent[i] = i
	}
	var find func(x int) int
	find = func(x int) int {
		if parent[x] != x {
			parent[x] = find(parent[x])
		}
		return parent[x]
	}
	union := func(i int, j int) bool {
		x, y := find(i), find(j)
		if x == y {
			return false
		}
		parent[x] = y
		return true
	}

	for _, edge := range edges {
		if !union(edge[0], edge[1]) {
			return edge
		}
	}
	return nil
}
