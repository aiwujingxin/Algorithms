package hot100

func subsets(nums []int) [][]int {
	var res [][]int
	var dfs func([]int, int, []int, *[][]int)
	dfs = func(nums []int, index int, temp []int, res *[][]int) {
		if index > len(nums)-1 {
			return
		}
		*res = append(*res, append([]int(nil), temp...))
		for i := index; i < len(nums); i++ {
			temp = append(temp, nums[i])
			dfs(nums, i+1, temp, res)
			temp = temp[0 : len(temp)-1]
		}
	}
	dfs(nums, 0, []int{}, &res)
	return res
}
