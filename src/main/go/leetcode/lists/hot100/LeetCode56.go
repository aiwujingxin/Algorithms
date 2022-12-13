package hot100

import "sort"

func merge(intervals [][]int) [][]int {

	if len(intervals) == 0 {
		return [][]int{}
	}
	// go study
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	var list [][]int
	list = append(list, intervals[0])
	for i := 1; i < len(intervals); i++ {
		last := list[len(list)-1]
		if last[1] < intervals[i][0] {
			list = append(list, intervals[i])
		} else {
			list = list[:len(list)-1]
			list = append(list, []int{last[0], Max(last[1], intervals[i][1])})
		}
	}
	return list
}
