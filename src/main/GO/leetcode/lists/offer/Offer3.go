package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/27 15:28
 */

func findRepeatNumber(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	mp := make(map[int]bool)
	for i := 0; i < len(nums); i++ {
		if mp[nums[i]] {
			return nums[i]
		}
		mp[nums[i]] = true
	}
	return -1
}
