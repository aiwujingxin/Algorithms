package topinterview

import (
	"sort"
	"strconv"
)

func largestNumber(nums []int) string {

	if len(nums) == 0 {
		return ""
	}
	list := make([]string, len(nums))
	for i := 0; i < len(nums); i++ {
		list[i] = strconv.Itoa(nums[i])
	}
	sort.Sort(strs(list))

	var res string

	for i := 0; i < len(list); i++ {
		res += list[i]
	}
	if res[0] == '0' {
		return "0"
	}
	return res
}

type strs []string

func (s strs) Len() int {
	return len(s)
}
func (s strs) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}
func (s strs) Less(i, j int) bool {
	return s[i]+s[j] > s[j]+s[i]
}
