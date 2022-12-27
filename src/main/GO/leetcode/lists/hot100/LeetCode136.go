package hot100

func singleNumber(nums []int) int {

	if len(nums) == 0 {
		return 0
	}
	var res int
	for i := 0; i < len(nums); i++ {
		res = res ^ nums[i]
	}
	return res
}
