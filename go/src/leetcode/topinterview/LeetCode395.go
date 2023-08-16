package topinterview

import "math"

func longestSubstring(s string, k int) int {
	res := math.MinInt32
	for totalCount := 1; totalCount <= 26; totalCount++ { //totalCount ?
		left, right := 0, 0
		count := 0
		charCount := 0
		feq := make([]int, 26)
		for right < len(s) {
			if feq[s[right]-'a'] == 1 {
				charCount++
			}
			feq[s[right]-'a']++
			if feq[s[right]-'a'] == k {
				count++
			}
			right++

			for charCount > totalCount { // 找到缩短的条件
				if feq[s[left]-'a'] == 1 {
					charCount--
				}
				feq[s[left]-'a']--
				if feq[s[left]-'a'] == k {
					count--
				}
				left++
			}
			if count == charCount {
				res = Max(right-left+1, res)
			}
			right++
		}
	}
	return res
}
