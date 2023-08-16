package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 16:30
 */

func combinationSum2(candidates []int, target int) [][]int {
	if len(candidates) == 0 {
		return [][]int{}
	}
	//sort.Ints(candidates)
	var res [][]int
	var dfs func(candidates []int, target int, sum int, index int, temp []int)
	dfs = func(candidates []int, target int, sum int, index int, temp []int) {
		if target < sum {
			return
		}
		mp := make(map[int]bool)
		if target == sum {
			res = append(res, append([]int(nil), temp...))
			return
		}
		for i := index; i < len(candidates); i++ {
			if mp[candidates[i]] {
				continue
			}
			mp[candidates[i]] = true
			dfs(candidates, target, sum+candidates[i], i, append(temp, candidates[i]))
		}
	}
	dfs(candidates, target, 0, 0, []int{})
	return res
}
