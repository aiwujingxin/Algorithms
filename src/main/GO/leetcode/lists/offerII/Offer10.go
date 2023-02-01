package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/12 16:06
 */

func subarraySum(nums []int, k int) int {
	if len(nums) == 0 {
		return 0
	}
	sum := make([]int, len(nums)+1)
	sum[0] = 0
	for i := 1; i <= len(nums); i++ {
		sum[i] = sum[i-1] + nums[i-1]
	}
	mp := make(map[int]int)
	res := 0
	for i := 0; i < len(sum); i++ {
		if count, ok := mp[sum[i]-k]; ok {
			res += count
		}
		mp[sum[i]]++
	}
	return res
}
