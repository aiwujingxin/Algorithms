package classic

import (
	"index/suffixarray"
	"sort"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/10 16:19
 */

func multiSearch(big string, smalls []string) [][]int {
	var result [][]int
	for _, val := range smalls {
		if val == "" {
			result = append(result, []int{})
			break
		}
		var res []int
		left, right := 0, len(val)
		for right <= len(big) {
			if val == big[left:right] {
				res = append(res, left)
			}
			left++
			right++
		}
		result = append(result, res)
	}
	return result
}

// V2
// https://leetcode.cn/problems/multi-search-lcci/solution/go-yu-yan-hou-zhui-shu-zu-by-endlesscheng/
func multiSearchV2(big string, smalls []string) [][]int {
	sa := suffixarray.New([]byte(big))
	pos := make([][]int, 0, len(smalls))
	for _, small := range smalls {
		ps := sa.Lookup([]byte(small), -1)
		sort.Ints(ps)
		pos = append(pos, ps)
	}
	return pos
}
