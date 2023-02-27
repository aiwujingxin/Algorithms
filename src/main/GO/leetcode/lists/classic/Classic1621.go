package classic

import (
	"fmt"
	"sort"
)

/**
 * @Author: jingxinwu
 * @Date: 2023/2/13 21:55
 */

func findSwapValues(array1 []int, array2 []int) []int {

	sum := 0
	sum1 := 0
	for i := 0; i < len(array1); i++ {
		sum += array1[i]
		sum1 += array1[i]
	}

	for i := 0; i < len(array2); i++ {
		sum += array2[i]
	}
	if sum%2 == 1 {
		return []int{}
	}
	find := func(nums []int, target int) int {
		left, right := 0, len(nums)-1
		for left <= right {
			mid := (left + right) / 2
			if nums[mid] == target {
				return mid
			}
			if nums[mid] < target {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
		return -1
	}
	sort.Ints(array2)
	for i := 0; i < len(array1); i++ {
		target := sum/2 - sum1 + array1[i]
		fmt.Println(target)
		index := find(array2, target)
		if index != -1 {
			return []int{array1[i], array2[index]}
		}
	}
	return []int{}
}
