package topinterview

func findOrder(numCourses int, prerequisites [][]int) []int {
	if numCourses == 0 {
		return []int{}
	}
	// 依赖的课程数
	arr := make([]int, numCourses)
	for _, p := range prerequisites {
		arr[p[0]]++
	}
	q := make([]int, 0)
	res := make([]int, 0)
	for i := 0; i < len(arr); i++ {
		if arr[i] == 0 {
			q = append(q, i)
			res = append(res, i)
		}
	}

	for len(q) > 0 {
		c := q[0]
		q = q[1:]
		for _, p := range prerequisites {
			if p[1] == c {
				arr[p[0]]--
				if arr[p[0]] == 0 {
					res = append(res, p[0])
					q = append(q, p[0])
				}
			}
		}
	}
	// fix 未学完
	for i := 0; i < len(arr); i++ {
		if arr[i] != 0 {
			return []int{}
		}
	}
	return res
}
