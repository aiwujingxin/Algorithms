package offer

import (
	"sort"
	"strconv"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 23:34
 */

func printNumbers(n int) []int {
	if n == 0 {
		return []int{}
	}
	arr := []byte{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}
	list := make([]string, 0)
	res := make([]int, 0)
	var dfs func(index int, s string)
	dfs = func(index int, s string) {
		if index > n {
			return
		}
		if len(s) > 0 {
			list = append(list, s)
		}
		for i := 0; i < len(arr); i++ {
			s = s + string(arr[i])
			dfs(index+1, s)
			s = s[:len(s)-1]
		}
	}
	dfs(0, "")
	for i := 0; i < len(list); i++ {
		if list[i][0] == '0' {
			continue
		}
		num, _ := strconv.Atoi(list[i])
		res = append(res, num)
	}
	sort.Ints(res)
	return res
}
