package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/2 21:43
 */

func majorityElement(nums []int) int {
	if len(nums) == 0 {
		return -1
	}

	candidate := 0
	count := 0
	for i := 0; i < len(nums); i++ {
		if count == 0 {
			candidate = nums[i]
		}
		if nums[i] != candidate {
			count--
		} else {
			count++
		}
	}
	count = 0
	for _, num := range nums {
		if num == candidate {
			count++
		}
	}
	if count*2 > len(nums) {
		return candidate
	}
	return -1
}
