package hot100

func permute(nums []int) [][]int {
	if len(nums) == 0 {
		return [][]int{}
	}
	list := make([][]int, 0)
	permuteHelper(nums, 0, &list)
	return list
}

func permuteHelper(nums []int, index int, res *[][]int) {
	if len(nums) == index {
		//go study
		c := append([]int(nil), nums...)
		*res = append(*res, c)
		return
	}
	for i := index; i < len(nums); i++ {
		swap(nums, i, index)
		permuteHelper(nums, index+1, res)
		swap(nums, i, index)
	}
}

func swap(nums []int, i int, index int) {
	nums[i], nums[index] = nums[index], nums[i]
}
