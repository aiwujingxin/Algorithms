package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 17:49
 */

func subsets(nums []int) [][]int {

	if len(nums) == 0 {
		return [][]int{}
	}
	res := make([][]int, 0)
	var dfs func(i int, t []int)

	dfs = func(index int, t []int) {
		res = append(res, append([]int(nil), t...))
		if index > len(nums) {
			return
		}
		for i := index; i < len(nums); i++ {
			dfs(i+1, append(t, nums[i]))
		}
	}
	dfs(0, make([]int, 0))
	return res
}
