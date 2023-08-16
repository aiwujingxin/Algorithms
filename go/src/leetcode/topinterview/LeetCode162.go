package topinterview

func findPeakElement(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	if len(nums) == 1 {
		return 0
	}

	left, right := 0, len(nums)-1

	for left <= right {
		mid := (left + right) / 2
		if mid == 0 && nums[mid] > nums[mid+1] || mid == len(nums)-1 && nums[mid] > nums[mid-1] {
			return mid
		}
		if nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1] {
			return mid
		}
		if mid > 0 && nums[mid] < nums[mid-1] {
			right = mid - 1
		} else if mid < len(nums)-1 && nums[mid] < nums[mid+1] {
			left = mid + 1
		}
	}
	return -1
}
