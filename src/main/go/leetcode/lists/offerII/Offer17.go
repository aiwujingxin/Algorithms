package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/14 16:04
 */

func minWindow(s string, t string) string {
	need, window := make(map[byte]int), make(map[byte]int)
	for i := 0; i < len(t); i++ {
		need[t[i]]++
	}
	left, right, start, end := 0, 0, 0, math.MaxInt64
	valid := 0
	for right < len(s) {
		ch := s[right]
		right++
		window[ch]++
		if window[ch] == need[ch] {
			valid++
		}
		for valid == len(need) {
			if right-left < end-start {
				start = left
				end = right
			}
			del := s[left]
			if need[del] == window[del] {
				valid--
			}
			window[del]--
			left++
		}
	}
	if end == math.MaxInt64 {
		return ""
	}
	return s[start:end]
}
