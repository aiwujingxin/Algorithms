package offer

import (
	"sort"
	"strconv"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/5 17:30
 */

func minNumber(nums []int) string {
	str := make([]string, 0)
	for _, n := range nums {
		str = append(str, strconv.Itoa(n))
	}
	sort.Sort(byLength(str))
	res := ""
	for _, s := range str {
		res = res + s
	}
	return res
}

type byLength []string

func (s byLength) Len() int {
	return len(s)
}
func (s byLength) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}
func (s byLength) Less(i, j int) bool {
	return s[i]+s[j] < s[j]+s[i]
}
