package hot100

import "sort"

//todo goPriorityQueue
func minMeetingRooms(intervals [][]int) int {

	if len(intervals) == 0 {
		return 0
	}
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] > intervals[j][0]
	})

	q := &PriorityQueue{
		ints: make([]int, 0),
	}
	q.ints.Push(intervals[0][1])
	for i := 1; i < len(intervals); i++ {
		if q.ints[0] <= intervals[i][0] {
			q.ints.Pop()
		}
		q.ints.Push(intervals[i][1])
	}
	return q.ints.Len()
}
