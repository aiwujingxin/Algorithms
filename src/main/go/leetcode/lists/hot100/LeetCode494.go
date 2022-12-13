package hot100

func findTargetSumWays(nums []int, target int) int {
	var count = 0
	var helper func([]int, int, int, int)

	helper = func(nums []int, target int, index int, sum int) {

		if index == len(nums) {
			if target == sum {
				count++
			}
		} else {
			helper(nums, target, index+1, sum+nums[index])
			helper(nums, target, index+1, sum-nums[index])
		}
		return
	}
	helper(nums, target, 0, 0)
	return count
}
