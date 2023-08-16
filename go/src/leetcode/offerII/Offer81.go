package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 11:53
 */

func combinationSum(candidates []int, target int) [][]int {

	if len(candidates) == 0 {
		return [][]int{}
	}
	var res [][]int
	var dfs func(candidates []int, target int, sum int, index int, temp []int)
	dfs = func(candidates []int, target int, sum int, index int, temp []int) {
		if target < sum {
			return
		}
		if target == sum {
			res = append(res, append([]int(nil), temp...))
			return
		}
		for i := index; i < len(candidates); i++ {
			dfs(candidates, target, sum+candidates[i], i, append(temp, candidates[i]))
		}
	}
	dfs(candidates, target, 0, 0, []int{})
	return res
}
