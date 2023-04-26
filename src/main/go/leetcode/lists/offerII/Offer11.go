package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 13:53
 */

//https://leetcode.cn/problems/A1NYOS/solution/chang-jian-zi-shu-zu-wen-ti-tong-yong-ji-v0n4/

func findMaxLength(nums []int) int {
	mp := make(map[int]int)
	ans := math.MinInt32
	one := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == 1 {
			one++
		} else {
			one--
		}
		if one == 0 {
			ans = i + 1
		} else if v, ok := mp[one]; ok {
			ans = Max(ans, i-v)
		} else {
			mp[one] = i
		}
	}
	if ans == math.MinInt32 {
		return 0
	}
	return ans
}

func findMaxLengthV2(nums []int) int {

	if len(nums) == 0 {
		return 0
	}
	sum := make([]int, len(nums)+1)
	for i := 1; i <= len(nums); i++ {
		var num = 0
		if nums[i-1] == 1 {
			num = 1
		} else {
			num = -1
		}
		sum[i] = sum[i-1] + num
	}
	mp := make(map[int]int)
	max := math.MinInt32
	for i := 1; i < len(nums); i++ {
		if index, ok := mp[sum[i]]; ok {
			max = Max(max, i-index-1)
		} else {
			mp[sum[i]] = i
		}
	}
	return max
}
