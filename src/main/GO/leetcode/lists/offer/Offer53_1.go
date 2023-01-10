package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 23:01
 */

func search(nums []int, target int) int {
	if len(nums) == 0 {
		return 0
	}
	left := searchL(nums, target)
	right := searchR(nums, target)
	if left == -1 || right == -1 {
		return 0
	}
	return right - left + 1
}

func searchL(nums []int, target int) int {
	idx := -1
	left, right := 0, len(nums)-1
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] == target {
			idx = mid
		}
		if nums[mid] >= target {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return idx
}

func searchR(nums []int, target int) int {
	idx := -1
	left, right := 0, len(nums)-1
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] == target {
			idx = mid
		}
		if nums[mid] <= target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return idx
}
