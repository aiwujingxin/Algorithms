package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/12 16:06
 */

func minSubArrayLen(target int, nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	sum := make([]int, len(nums)+1)
	for i := 1; i <= len(nums); i++ {
		sum[i] = sum[i-1] + nums[i-1]
	}
	min := math.MaxInt32
	for i := 0; i < len(sum); i++ {
		if sum[i] < target {
			continue
		}
		index := findIndex(sum, sum[i]-target)
		if index == -1 {
			continue
		}
		if i-index < min {
			min = Min(min, i-index)
		}
	}
	if min == math.MaxInt32 {
		return 0
	}
	return min
}

func findIndex(nums []int, value int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := (right + left) / 2
		if nums[mid] == value {
			return mid
		}
		if nums[mid] < value {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return right
}

// 滑动窗口
func minSubArrayLenSD(target int, nums []int) int {
	left, sum := 0, 0
	minLength := math.MaxInt32
	for right := 0; right < len(nums); right++ {
		sum += nums[right]
		for left <= right && sum >= target {
			minLength = Min(minLength, right-left+1)
			sum -= nums[left]
			left++
		}
	}
	if minLength == math.MaxInt32 {
		return 0
	}
	return minLength
}
