package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/21 22:38
 */

func subsets(nums []int) [][]int {
	if len(nums) == 0 {
		return [][]int{}
	}
	res := make([][]int, 0)
	var dfs func(nums []int, index int, temp []int)
	dfs = func(nums []int, index int, temp []int) {
		res = append(res, append([]int(nil), temp...))
		for i := index; i < len(nums); i++ {
			temp = append(temp, nums[i])
			dfs(nums, i+1, temp)
			temp = temp[:len(temp)-1]
		}
	}
	dfs(nums, 0, []int{})
	return res
}
