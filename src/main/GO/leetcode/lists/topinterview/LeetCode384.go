package topinterview

import "math/rand"

type Solution struct {
	nums   []int
	origin []int
}

func ConstructorNums(nums []int) Solution {
	//fix
	return Solution{nums, append([]int(nil), nums...)}
}

func (this *Solution) Reset() []int {
	return this.origin
}

func (this *Solution) Shuffle() []int {
	for i := 0; i < len(this.nums); i++ {
		r := rand.Intn(len(this.nums) - i)
		this.nums[i], this.nums[r] = this.nums[r], this.nums[i]
	}
	return this.nums
}
