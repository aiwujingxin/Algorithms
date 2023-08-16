package hot100

func majorityElement(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	mp := make(map[int]int)
	for _, n := range nums {
		mp[n] = mp[n] + 1
	}
	for k, v := range mp {
		if v > len(nums)/2 {
			return k
		}
	}
	return -1
}
