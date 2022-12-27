package topinterview

import (
	"container/heap"
	"sort"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/27 13:45
 */

func getSkylineQ(buildings [][]int) [][]int {
	n := len(buildings)
	boundaries := make([]int, 0, 2*n)
	for i := range buildings {
		boundaries = append(boundaries, buildings[i][0], buildings[i][1])
	}
	sort.Ints(boundaries)

	h := Heap{}
	cur := 0
	ans := make([][]int, 0)
	for _, boundary := range boundaries {
		for h.Len() > 0 && h.pairs[0].right <= boundary {
			heap.Pop(&h)
		}
		for cur < n && buildings[cur][0] <= boundary && buildings[cur][1] > boundary {
			heap.Push(&h, pair{right: buildings[cur][1], height: buildings[cur][2]})
			cur++
		}
		maxHeight := 0
		if h.Len() > 0 {
			maxHeight = h.pairs[0].height
		}
		if len(ans) == 0 || maxHeight != ans[len(ans)-1][1] {
			ans = append(ans, []int{boundary, maxHeight})
		}
	}
	return ans
}

type pair struct {
	right, height int
}

type Heap struct {
	pairs []pair
}

func (h *Heap) Len() int {
	return len(h.pairs)
}

func (h *Heap) Less(i, j int) bool {
	return h.pairs[i].height >= h.pairs[j].height
}

func (h *Heap) Swap(i, j int) {
	h.pairs[i], h.pairs[j] = h.pairs[j], h.pairs[i]
}

func (h *Heap) Push(v interface{}) {
	h.pairs = append(h.pairs, v.(pair))
}

func (h *Heap) Pop() interface{} {
	x := h.pairs[len(h.pairs)-1]
	h.pairs = h.pairs[:len(h.pairs)-1]
	return x
}
