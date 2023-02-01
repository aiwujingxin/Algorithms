package offerII

import (
	"container/heap"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/18 14:00
 */

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
	h := &MyHeap{}
	heap.Init(h)
	for i := 0; i < len(nums1); i++ {
		for j := 0; j < len(nums2); j++ {
			heap.Push(h, []int{nums1[i], nums2[j]})
			if h.Len() > k {
				heap.Pop(h)
			}
		}
	}
	res := make([][]int, 0)
	for i := 0; i < k; i++ {
		if h.Len() > 0 {
			res = append(res, heap.Pop(h).([]int))
		}
	}
	return res
}

type MyHeap [][]int

func (h MyHeap) Len() int { return len(h) }

// Less 小顶堆
// 如果 i>j , 就需要向下调整
func (h MyHeap) Less(i, j int) bool { return h[i][0]+h[i][1] > h[j][0]+h[j][1] }
func (h MyHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MyHeap) Push(x interface{}) {
	*h = append(*h, x.([]int))
}

func (h *MyHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
