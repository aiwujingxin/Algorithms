package classic

import "math"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/13 22:42
 */
//https://leetcode.cn/problems/sub-sort-lcci/solution/1ms-by-15066212pp-3bf0/

func subSort(array []int) []int {
	n := len(array)
	l, r := -1, -1
	min := math.MaxInt32
	for i := n - 1; i >= 0; i-- {
		if array[i] > min {
			l = i
		} else {
			min = array[i]
		}
	}
	max := math.MinInt32
	for i, num := range array {
		if num < max {
			r = i
		} else {
			max = num
		}
	}
	return []int{l, r}
}
