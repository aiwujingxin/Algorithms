package hot100

func findDisappearedNumbers(nums []int) []int {
	if len(nums) == 0 {
		return []int{}
	}
	for _, n := range nums {
		if n < 0 {
			n = n * -1
		}
		index := n - 1
		if nums[index] > 0 {
			nums[index] = nums[index] * -1
		}
	}
	var res []int
	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			res = append(res, i+1)
		}
	}
	return res
}
