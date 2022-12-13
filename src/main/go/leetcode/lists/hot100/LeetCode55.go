
package hot100

func canJump(nums []int) bool {
	if len(nums) == 0 {
		return true
	}

	var step = nums[0]
	for i := 1; i < len(nums); i++ {
		if i > step {
			return false
		}
		step = Max(step, i+nums[i])
	}
	return true
}
