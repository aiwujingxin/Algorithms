package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 15:11
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
			j = Max(j, v)
		}
		max = Max(i-j, max)
		mp[s[i]] = i
	}
	return max
}

//====V2====
func lengthOfLongestSubstringSD(s string) int {
	mp := make(map[byte]int)
	left, right, res := 0, 0, 0
	for right < len(s) {
		c := s[right]
		mp[c]++
		right++
		for mp[c] > 1 {
			d := s[left]
			left++
			mp[d]--
		}
		res = Max(res, right-left)
	}
	return res
}
