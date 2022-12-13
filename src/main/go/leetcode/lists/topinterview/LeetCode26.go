package topinterview

func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	left, right := 0, 1
	for right < len(nums) {
		if nums[right] <= nums[left] {
			right++
		} else {
			left++
			nums[left], nums[right] = nums[right], nums[left]
		}
	}
	return left + 1
}
