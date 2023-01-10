package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 23:45
 */

func missingNumber(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	nums = append(nums, 0)
	for i := 0; i < len(nums)-1; i++ {
		index := Abs(nums[i])
		nums[index] = -nums[index]
	}
	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			return i
		}
	}
	return len(nums) - 1
}
