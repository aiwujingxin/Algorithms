package hot100

func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}
	mp := make(map[rune]int)
	j := -1
	var res int
	for i, ch := range s {
		if v, ok := mp[ch]; ok {
			j = Max(j, v)
		}
		res = Max(res, i-j)
		mp[ch] = i
	}
	return res
}
