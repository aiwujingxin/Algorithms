package hot100

import "container/heap"

type FreqValue struct {
	frequency int
	value     int
}
type FVHeap []FreqValue

func (h FVHeap) Len() int           { return len(h) }
func (h FVHeap) Less(i, j int) bool { return h[i].frequency > h[j].frequency }
func (h FVHeap) Swap(i, j int) {
	h[i].frequency, h[i].value, h[j].frequency, h[j].value = h[j].frequency, h[j].value, h[i].frequency, h[i].value
}

func (h *FVHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(FreqValue))
}
func (h *FVHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func topKFrequent(nums []int, k int) []int {
	mp := make(map[int]int)
	for _, value := range nums {
		mp[value]++
	}
	list := new(FVHeap)
	heap.Init(list)
	for value, freq := range mp {
		heap.Push(list, FreqValue{freq, value})
	}
	var ret []int
	for ; k >= 1; k-- {
		freqValue := heap.Pop(list).(FreqValue)
		ret = append(ret, freqValue.value)
	}
	return ret
}
