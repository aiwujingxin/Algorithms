package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/19 15:23
 */

func searchInsert(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}
	if target < nums[0] {
		return 0
	}
	if target > nums[len(nums)-1] {
		return len(nums)
	}
	left, right := 0, len(nums)-1
	for left < right {
		mid := (left + right) / 2
		if nums[mid] >= target {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return right
}
