package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/31 22:08
 */

func sequenceReconstruction(nums []int, sequences [][]int) bool {
	if len(nums) == 0 {
		return true
	}
	graph := make(map[int]map[int]bool)
	indegrees := make(map[int]int)
	buildGraph := func(sequences [][]int) bool {

		for i := 0; i < len(sequences); i++ {
			sequence := sequences[i]
			for j := 0; j < len(sequence); j++ {
				if len(graph[sequence[j]]) == 0 {
					graph[sequence[j]] = make(map[int]bool)
				}
			}
			for j := 0; j < len(sequence)-1; j++ {
				first := sequence[j]
				second := sequence[j+1]
				if first < 0 || first > len(nums) || second < 0 || second > len(nums) {
					return false
				}
				if _, ok := graph[first][second]; !ok {
					graph[first][second] = true
					indegrees[second]++
				}
			}
		}
		return true
	}
	if !buildGraph(sequences) {
		return false
	}

	q := make([]int, 0)
	for k := range graph {
		if indegrees[k] == 0 {
			q = append(q, k)
		}
	}

	build := make([]int, 0)
	for len(q) == 1 {
		num := q[0]
		q = q[1:]
		build = append(build, num)
		for next := range graph[num] {
			indegrees[next]--
			if indegrees[next] == 0 {
				q = append(q, next)
			}
		}
	}
	if len(build) != len(nums) {
		return false
	}
	for i := 0; i < len(build); i++ {
		if build[i] != nums[i] {
			return false
		}
	}
	return true
}
