package hot100

import "math"

func findUnsortedSubarray(nums []int) int {
	min, max := math.MaxInt64, math.MinInt64
	for i := 1; i < len(nums); i++ {
		if nums[i] < nums[i-1] {
			min = Min(min, nums[i])   //自min以后都是递增
			max = Max(max, nums[i-1]) //自max以后都是递增
		}
	}
	if min > max {
		return 0
	}
	l, r := 0, len(nums)-1
	for nums[l] <= min {
		l++
	}
	for nums[r] >= max {
		r--
	}
	return r - l + 1
}
