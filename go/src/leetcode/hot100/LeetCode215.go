package hot100

func findKthLargest(nums []int, k int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) < k {
		return -1
	}
	left, right := 0, len(nums)-1
	for left <= right {
		index := findKthLargestHelper(nums, left, right)
		if index+1 == k {
			return nums[index]
		} else if index+1 < k {
			left = index + 1
		} else {
			right = index - 1
		}
	}
	return -1
}

func findKthLargestHelper(nums []int, left, right int) int {
	pi := nums[left]
	for left < right {
		// 搞清楚顺序
		for left < right && nums[right] <= pi {
			right--
		}
		nums[left] = nums[right]
		for left < right && nums[left] >= pi {
			left++
		}
		nums[right] = nums[left]
	}
	nums[left] = pi
	return left
}
