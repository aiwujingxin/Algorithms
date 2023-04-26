package topinterview

func rotate(nums []int, k int) {
	if k == 0 {
		return
	}
	k = k % len(nums)
	Reverse(nums, 0, len(nums)-k)
	Reverse(nums, len(nums)-1-k, len(nums)-1)
	Reverse(nums, 0, len(nums)-1)
}
