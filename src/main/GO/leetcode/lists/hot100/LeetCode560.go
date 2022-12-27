package hot100

func subarraySum(nums []int, k int) int {
	if len(nums) == 0 {
		return 0
	}
	mp := make(map[int]int)
	sum := make([]int, len(nums)+1)
	sum[0] = 0
	for i := 1; i <= len(nums); i++ {
		sum[i] = sum[i-1] + nums[i-1]
	}
	var res int
	for i := 0; i < len(sum); i++ {
		if v, ok := mp[sum[i]-k]; ok {
			res += v
		}
		mp[sum[i]] = mp[sum[i]] + 1
	}
	return res
}
