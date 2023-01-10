package offer

import "sort"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 23:54
 */

func isStraight(nums []int) bool {
	zeroCnt := 0
	sort.Ints(nums)
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] == 0 {
			zeroCnt++
		} else if nums[i] == nums[i+1] {
			return false
		}
	}
	return nums[4]-nums[zeroCnt] < 5
}
