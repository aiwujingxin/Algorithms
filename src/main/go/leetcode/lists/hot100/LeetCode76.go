package hot100

import "math"

func minWindow(s string, t string) string {
	need, window := make(map[byte]int), make(map[byte]int)
	for i := 0; i < len(t); i++ {
		need[t[i]] = need[t[i]] + 1
	}
	left, right, start, end := 0, 0, 0, math.MaxInt64
	valid := 0
	for right < len(s) {
		ch := s[right]
		right++
		window[ch] = window[ch] + 1
		if window[ch] == need[ch] {
			valid++
		}

		for valid == len(need) {
			if right-left < end-start {
				start = left
				end = right
			}
			del := s[left]
			left++
			if need[del] == window[del] {
				valid--
			}
			window[del] = window[del] - 1
		}
	}
	if end == math.MaxInt64 {
		return ""
	}
	return s[start:end]
}
