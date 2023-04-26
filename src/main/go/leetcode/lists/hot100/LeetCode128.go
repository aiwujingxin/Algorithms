package hot100

func longestConsecutive(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	set := make(map[int]bool)
	for _, nu := range nums {
		set[nu] = true
	}
	var res int
	for nu := range set {
		temp := 1
		if _, ok := set[nu-1]; !ok {
			for set[nu+1] {
				temp++
				nu++
			}
		}
		res = Max(res, temp)
	}
	return res
}
