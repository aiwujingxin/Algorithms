package hot100

func findAnagrams(s string, p string) []int {
	need, window := make(map[byte]int), make(map[byte]int)
	left, right := 0, 0
	valid := 0
	res := make([]int, 0)
	for i := range p {
		need[p[i]] = need[p[i]] + 1
	}
	for right < len(s) {
		c := s[right]
		right++
		//进行窗口内数据的一系列更新
		if _, ok := need[c]; ok {
			window[c] = window[c] + 1
			if need[c] == window[c] {
				valid++
			}
		}
		for right-left >= len(p) {
			if valid == len(need) {
				res = append(res, left)
			}

			d := s[left]
			if _, ok := need[d]; ok {
				if window[d] == need[d] {
					valid--
				}
				window[d] = window[d] - 1
			}
			left++
		}
	}
	return res
}
