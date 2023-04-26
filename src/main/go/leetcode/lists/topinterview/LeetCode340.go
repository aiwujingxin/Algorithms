package topinterview

func lengthOfLongestSubstringKDistinct(s string, k int) int {
	if len(s) == 0 || k == 0 {
		return 0
	}
	left, right, n := 0, 0, len(s)
	mp := make(map[byte]int)
	res := 0
	charCount := 0
	for right < n {
		mp[s[right]]++
		if mp[s[right]] == 1 {
			charCount++
		}
		for charCount > k {
			if mp[s[left]] == 1 {
				charCount--
			}
			mp[s[left]]--
			left++
		}
		if charCount <= k {
			res = Max(right-left+1, res)
		}
		right++
	}
	return res
}
