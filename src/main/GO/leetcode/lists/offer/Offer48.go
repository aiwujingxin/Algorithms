package offer

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 22:36
 */

func lengthOfLongestSubstring(s string) int {

	if len(s) == 0 {
		return 0
	}
	mp := make(map[byte]int)
	j := -1
	max := math.MinInt32
	for i := 0; i < len(s); i++ {
		if v, ok := mp[s[i]]; ok {
			j = Max(v, mp[s[i]])
		}
		mp[s[i]] = i
		max = Max(max, i-j)
	}
	return max
}
