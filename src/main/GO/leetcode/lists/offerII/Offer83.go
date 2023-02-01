package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 16:32
 */

func permute(nums []int) [][]int {
	if len(nums) == 0 {
		return [][]int{}
	}
	res := make([][]int, 0)
	var dfs func(nums []int, index int)
	dfs = func(nums []int, index int) {
		if index == len(nums) {
			res = append(res, append([]int(nil), nums...))
			return
		}
		for i := index; i < len(nums); i++ {
			nums[i], nums[index] = nums[index], nums[i]
			dfs(nums, index+1)
			nums[i], nums[index] = nums[index], nums[i]
		}
	}
	dfs(nums, 0)
	return res
}
