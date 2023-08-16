package offerII

import (
	"container/heap"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/17 16:44
 */

type KthLargest struct {
	k    int
	nums Iheap
}

func ConstructorKthLargest(k int, nums []int) KthLargest {
	k1 := KthLargest{k: k}
	for _, v := range nums {
		k1.Add(v)
	}
	return k1
}

func (k *KthLargest) Add(val int) int {
	heap.Push(&k.nums, val)
	if len(k.nums) > k.k {
		heap.Pop(&k.nums)
	}
	return k.nums[0]
}

//========================V2=================

type KthLargestV2 struct {
	k    int
	heap []int
}

func ConstructorKthLargestV2(k int, nums []int) KthLargestV2 {
	res := KthLargestV2{
		k:    k,
		heap: nums,
	}

	for i := len(res.heap)/2 - 1; i > -1; i-- {
		res.heapDown(i, len(res.heap)-1)
	}

	return res
}

func (this *KthLargestV2) Add(val int) int {
	return this.add(val)
}

func (this *KthLargestV2) add(val int) int {
	this.heap = append(this.heap, val)
	this.heapUp(len(this.heap) - 1)

	for len(this.heap) > this.k {
		this.pop()
	}

	return this.heap[0]
}

func (this *KthLargestV2) pop() int {
	if len(this.heap) == 0 {
		panic("empty heap")
	}

	poppedItem := this.heap[0]

	this.heap[0], this.heap[len(this.heap)-1] = this.heap[len(this.heap)-1], this.heap[0]
	this.heap = this.heap[:len(this.heap)-1]

	//向下调整
	this.heapDown(0, len(this.heap)-1)

	return poppedItem
}

func (this *KthLargestV2) heapUp(pos int) {
	parent := (pos - 1) / 2

	if parent >= 0 && this.heap[pos] < this.heap[parent] {
		this.heap[pos], this.heap[parent] = this.heap[parent], this.heap[pos]
		this.heapUp(parent)
	}
}

//向下调整
func (this *KthLargestV2) heapDown(pos int, limit int) {
	l, r := 2*pos+1, 2*pos+2
	smaller := pos

	if l <= limit && this.heap[l] < this.heap[smaller] {
		smaller = l
	}

	if r <= limit && this.heap[r] < this.heap[smaller] {
		smaller = r
	}

	if smaller != pos {
		this.heap[smaller], this.heap[pos] = this.heap[pos], this.heap[smaller]
		this.heapDown(smaller, limit)
	}
}
