package offer

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/29 19:42
 */

func majorityElement(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	count := 0
	num := math.MinInt32
	for i := 0; i < len(nums); i++ {
		if count == 0 {
			num = nums[i]
		}
		if num == nums[i] {
			count++
		} else {
			count--
		}
	}
	return num
}
