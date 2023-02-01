package offerII

import "sort"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/20 22:57
 */

func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return [][]int{}
	}
	res := make([][]int, 0)
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] > intervals[j][0]
	})
	res = append(res, intervals[0])
	for i := 1; i < len(intervals); i++ {
		last := res[len(res)-1]
		if last[1] < intervals[i][0] {
			res = append(res, intervals[i])
		} else {
			res = res[:len(res)-1]
			res = append(res, []int{last[0], Max(last[1], intervals[i][1])})
		}
	}
	return res
}
