package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/19 16:11
 */

func singleNonDuplicate(nums []int) int {
	n := len(nums)
	l := 0
	r := n - 1
	ans := -1
	for l <= r {
		mid := l + (r-l)/2
		if mid < n-1 && nums[mid] == nums[mid+1] {
			if mid%2 == 0 {
				l = mid + 2
			} else {
				r = mid - 1
			}
		} else if mid > 0 && nums[mid] == nums[mid-1] {
			if mid%2 == 0 {
				r = mid - 2
			} else {
				l = mid + 1
			}
		} else {
			ans = nums[mid]
			break
		}
	}
	return ans
}
