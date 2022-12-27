package topinterview

func containsDuplicate(nums []int) bool {
	set := map[int]bool{}
	for _, v := range nums {
		if _, has := set[v]; has {
			return true
		}
		set[v] = true
	}
	return false
}
