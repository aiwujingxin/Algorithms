package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 23:29
 */

func searchV2(nums []int, target int) int {
	if len(nums) == 0 {
		return 0
	}

	left := 0
	right := len(nums) - 1
	for left < right {
		mid := (left + right) / 2
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			right = mid
		}
	}
	if nums[left] != target {
		return 0
	}

	idx := left
	left = 0
	right = len(nums) - 1
	for left < right {
		mid := (left + right + 1) / 2
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			left = mid
		}
	}
	return left - idx + 1
}
