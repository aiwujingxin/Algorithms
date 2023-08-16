package topinterview

import "math"

func increasingTriplet(nums []int) bool {
	if len(nums) < 3 {
		return false
	}
	if len(nums) == 3 {
		return nums[0] < nums[1] && nums[1] < nums[2]
	}
	min1, min2 := nums[0], math.MaxInt32
	for i := 1; i < len(nums); i++ {
		if nums[i] > min2 {
			return true
		} else if nums[i] > min1 {
			min2 = nums[i]
		} else {
			min1 = nums[i]
		}
	}
	return false
}
