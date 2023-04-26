package hot100

import "sort"

func reconstructQueue(people [][]int) [][]int {

	if len(people) == 0 {
		return nil
	}
	sort.Slice(people, func(i, j int) bool {
		if people[i][0] == people[j][0] {
			return people[i][1] < people[j][1]
		}
		return people[i][0] > people[j][0]
	})
	list := make([][]int, 0, len(people))
	for _, person := range people {
		idx := person[1]
		list = append(list[:idx], append([][]int{person}, list[idx:]...)...)
	}
	return list
}
