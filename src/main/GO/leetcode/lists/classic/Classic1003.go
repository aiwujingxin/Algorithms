package classic

import "fmt"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/14 14:46
 */

func search(nums []int, target int) int {
	n := len(nums)
	left := 0
	right := n - 1
	// 恢复二段性
	for left < right && nums[0] == nums[right] {
		right--
	}

	idx := findPeak(nums, left, right)
	fmt.Print(idx)
	ans := -1
	// 第二次二分，找目标值
	if target >= nums[0] && target <= nums[idx] {
		ans = find(nums, 0, idx, target)
	} else {
		ans = find(nums, idx+1, n-1, target)
	}
	if ans != -1 {
		return ans
	}
	return -1
}

func find(nums []int, l int, r int, t int) int {
	for l < r {
		mid := (l + r) >> 1
		if nums[mid] >= t {
			r = mid
		} else {
			l = mid + 1
		}
	}
	if nums[r] == t {
		return r
	}
	return -1
}

func findPeak(nums []int, start, end int) int {
	if len(nums) == 0 {
		return 0
	}
	left, right := start, end
	for left+1 < right {
		mid := (left + right) / 2
		if nums[mid] >= nums[left] {
			left = mid
		} else {
			right = mid - 1
		}
	}
	if nums[right] >= nums[left] {
		return right
	}
	return left
}
