package topinterview

func firstUniqChar(s string) int {
	if len(s) == 0 {
		return 0
	}
	mp := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		mp[s[i]]++
	}
	for i := 0; i < len(s); i++ {
		if v, ok := mp[s[i]]; ok {
			if v == 1 {
				return i
			}
		}
	}
	return -1
}
