package offerII

func numSimilarGroups(strs []string) int {
	if len(strs) == 0 {
		return 0
	}
	parent := make([]int, len(strs))
	for i := 0; i < len(parent); i++ {
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
	can := func(s1, s2 string) bool {
		diff := 0
		for i := 0; i < len(s1); i++ {
			if s1[i] != s2[i] {
				diff++
			}
		}
		return diff <= 2
	}
	group := len(strs)
	for i := 0; i < len(strs); i++ {
		for j := 0; j < len(strs); j++ {
			if can(strs[i], strs[j]) && union(i, j) {
				group--
			}
		}
	}
	return group
}
