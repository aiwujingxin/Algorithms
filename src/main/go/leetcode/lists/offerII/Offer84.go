package offerII

import "sort"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 16:38
 */

func permuteUnique(nums []int) [][]int {
	if len(nums) == 0 {
		return [][]int{}
	}
	res := make([][]int, 0)
	sort.Ints(nums)
	var dfs func(nums []int, index int)
	dfs = func(nums []int, index int) {
		if index == len(nums) {
			res = append(res, append([]int(nil), nums...))
			return
		}
		mp := make(map[int]bool)
		for i := index; i < len(nums); i++ {
			if mp[nums[i]] {
				continue
			}
			mp[nums[i]] = true
			nums[i], nums[index] = nums[index], nums[i]
			dfs(nums, index+1)
			nums[i], nums[index] = nums[index], nums[i]
		}
	}
	dfs(nums, 0)
	return res
}
