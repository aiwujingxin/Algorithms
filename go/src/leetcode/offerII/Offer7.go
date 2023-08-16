package offerII

import "sort"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/11 18:40
 */

func threeSum(nums []int) [][]int {
	if len(nums) == 0 {
		return [][]int{}
	}
	res := make([][]int, 0)
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		left, right := i+1, len(nums)-1
		for left < right {
			if nums[left]+nums[right]+nums[i] == 0 {
				res = append(res, []int{nums[left], nums[right], nums[i]})
				for left < right && nums[left+1] == nums[left] {
					left++
				}
				left++
				for left < right && nums[right-1] == nums[right] {
					right--
				}
				right--
			} else if nums[left]+nums[right]+nums[i] < 0 {
				left++
			} else {
				right--
			}
		}
	}
	return res
}
