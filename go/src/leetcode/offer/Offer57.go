package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 19:59
 */

func twoSum(nums []int, target int) []int {

	mp := make(map[int]bool)

	for i := 0; i < len(nums); i++ {
		if _, ok := mp[target-nums[i]]; ok {
			return []int{nums[i], target - nums[i]}
		}
		mp[nums[i]] = true
	}
	return []int{}
}
