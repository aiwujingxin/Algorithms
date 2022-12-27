package hot100

func twoSum(nums []int, target int) []int {
	mp := make(map[int]int)
	for i, n := range nums {
		if v, ok := mp[target-n]; ok {
			return []int{v, i}
		} else {
			mp[n] = i
		}
	}
	return []int{}
}
