package topinterview

import (
	"strconv"
)

func findMissingRanges(nums []int, lower int, upper int) []string {
	if len(nums) == 0 {
		if lower == upper {
			return []string{strconv.Itoa(lower)}
		}
		return []string{strconv.Itoa(lower) + "->" + strconv.Itoa(upper)}
	}
	list := make([][]int, 0)
	if lower < nums[0] {
		list = append(list, []int{lower, nums[0] - 1})
	}
	for i := 0; i < len(nums)-1; i++ {
		if nums[i]+1 < nums[i+1] {
			list = append(list, []int{nums[i] + 1, nums[i+1] - 1})
		}
	}
	if nums[len(nums)-1] < upper {
		list = append(list, []int{nums[len(nums)-1] + 1, upper})
	}
	res := make([]string, 0)
	for i := 0; i < len(list); i++ {
		if list[i][0] == list[i][1] {
			res = append(res, strconv.Itoa(list[i][0]))
		} else {
			res = append(res, strconv.Itoa(list[i][0])+"->"+strconv.Itoa(list[i][1]))
		}
	}
	return res
}
