package hot100

func maxProduct(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	max := nums[0]
	min := nums[0]
	res := nums[0]
	for i := 1; i < len(nums); i++ {
		mx, mn := max, min
		max = Max(Max(mx*nums[i], mn*nums[i]), nums[i])
		min = Min(Min(mx*nums[i], mn*nums[i]), nums[i])
		res = Max(res, max)
	}
	return res
}
