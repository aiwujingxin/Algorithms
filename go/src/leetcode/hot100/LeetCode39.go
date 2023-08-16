package hot100

func combinationSum(candidates []int, target int) [][]int {
	if len(candidates) == 0 {
		return [][]int{}
	}
	var res [][]int
	var dfs func([]int, []int, int, int, int, *[][]int)
	dfs = func(candidates []int, temp []int, index int, sum int, target int, res *[][]int) {
		if target < sum {
			return
		}
		if target == sum {
			*res = append(*res, append([]int(nil), temp...))
			return
		}
		for i := index; i < len(candidates); i++ {
			temp = append(temp, candidates[i])
			sum = sum + candidates[i]
			dfs(candidates, temp, i, sum, target, res)
			temp = temp[:len(temp)-1]
			sum = sum - candidates[i]
		}
	}
	dfs(candidates, []int{}, 0, 0, target, &res)
	return res
}
