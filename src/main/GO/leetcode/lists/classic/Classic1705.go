package classic

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/16 18:45
 */

//["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]

func findLongestSubarray(array []string) []string {

	if len(array) == 0 {
		return []string{}
	}
	nums := make([]int, len(array))
	for i := 0; i < len(array); i++ {
		if array[i] >= "A" && array[i] <= "Z" || array[i] >= "a" && array[i] <= "z" {
			nums[i] = -1
		} else {
			nums[i] = 1
		}
	}
	mp := make(map[int]int)

	sum := make([]int, len(nums)+1)
	sum[0] = 0
	for i := 1; i < len(nums); i++ {
		sum[i] = sum[i-1] + nums[i]
	}
	max := math.MinInt32
	l, r := 0, 0
	for i := 0; i < len(sum); i++ {
		if index, ok := mp[sum[i]]; ok {
			if i-index-1 > max {
				max = i - index - 1
				l = index
				r = i
			}
		} else {
			mp[sum[i]] = i
		}
	}
	return array[l:r]
}
