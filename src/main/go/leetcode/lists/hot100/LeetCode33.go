package hot100

func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}
	left, right := 0, len(nums)-1
	for left+1 < right {
		mid := (right + left) / 2
		if nums[left] < nums[mid] {
			// fix
			if target >= nums[left] && target < nums[mid] {
				right = mid
			} else {
				left = mid
			}
		} else {
			// fix
			if target <= nums[right] && target > nums[mid] {
				left = mid
			} else {
				right = mid
			}

		}
	}
	if nums[left] == target {
		return left
	}
	if nums[right] == target {
		return right
	}
	return -1
}
