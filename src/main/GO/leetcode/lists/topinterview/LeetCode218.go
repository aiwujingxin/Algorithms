package topinterview

import (
	"container/heap"
	"sort"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/26 19:12
 */

//https://leetcode.com/problems/the-skyline-problem/solutions/61232/golang-heap-solution/

func getSkyline(buildings [][]int) [][]int {
	points := make([]*RoofPoint, len(buildings)*2)
	rightToLeftMap := make(map[*RoofPoint]*RoofPoint)

	for i := 0; i < len(buildings); i++ {
		points[i*2] = &RoofPoint{IsLeft: true, X: buildings[i][0], Height: buildings[i][2]}
		points[1+i*2] = &RoofPoint{IsLeft: false, X: buildings[i][1], Height: buildings[i][2]}
		rightToLeftMap[points[1+i*2]] = points[i*2]
	}
	sort.Sort(ByXAsc(points))

	pq := make(PQ, 0)
	heap.Init(&pq)

	var result [][]int
	for i := 0; i < len(points); i++ {
		point := points[i]
		if point.IsLeft {
			heap.Push(&pq, point)
			if len(result) == 0 {
				result = append(result, []int{point.X, point.Height})
				continue
			}

			highest := pq[0]
			if result[len(result)-1][1] >= highest.Height {
				continue
			}

			if result[len(result)-1][0] == point.X {
				result[len(result)-1][1] = highest.Height

				if len(result) > 1 && result[len(result)-2][1] == highest.Height {
					result = result[:len(result)-1]
				}
			} else {
				result = append(result, []int{point.X, highest.Height})
			}
			continue
		}

		heap.Remove(&pq, rightToLeftMap[point].HeapIdx)

		if len(pq) == 0 {
			if result[len(result)-1][0] < point.X {
				result = append(result, []int{point.X, 0})
			} else {
				result[len(result)-1][1] = 0
			}
			continue
		}

		highest := pq[0]
		if result[len(result)-1][1] > highest.Height {
			if result[len(result)-1][0] < point.X {
				result = append(result, []int{point.X, highest.Height})
			} else {
				result[len(result)-1][1] = highest.Height
			}
		}
	}
	return result
}

type RoofPoint struct {
	HeapIdx int
	IsLeft  bool
	X       int
	Height  int
}

type ByXAsc []*RoofPoint

func (points ByXAsc) Len() int {
	return len(points)
}

func (points ByXAsc) Swap(i, j int) {
	points[i], points[j] = points[j], points[i]
}

func (points ByXAsc) Less(i, j int) bool {
	return points[i].X < points[j].X
}

type PQ []*RoofPoint

func (points PQ) Len() int {
	return len(points)
}

func (points PQ) Swap(i, j int) {
	points[i], points[j] = points[j], points[i]
	points[i].HeapIdx = i
	points[j].HeapIdx = j
}

func (points PQ) Less(i, j int) bool {
	if points[i].Height == points[j].Height {
		return !points[i].IsLeft
	}
	return points[i].Height > points[j].Height
}

func (points *PQ) Push(item interface{}) {
	newP := item.(*RoofPoint)
	newP.HeapIdx = len(*points)
	*points = append(*points, newP)
}

func (points *PQ) Pop() interface{} {
	tmp := (*points)[len(*points)-1]
	tmp.HeapIdx = -1
	*points = (*points)[:len(*points)-1]
	return tmp
}
