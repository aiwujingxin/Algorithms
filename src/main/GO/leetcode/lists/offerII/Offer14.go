package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 16:15
 */

func checkInclusion(s1 string, s2 string) bool {
	if len(s2) == 0 {
		return false
	}
	need := make(map[byte]int)
	window := make(map[byte]int)
	valid := 0
	left, right := 0, 0

	for i := 0; i < len(s1); i++ {
		need[s1[i]]++
	}
	for right < len(s2) {
		c := s2[right]
		window[c]++
		right++

		if need[c] == window[c] {
			valid++
		}
		for right-left >= len(s1) {
			if valid == len(need) {
				return true
			}
			d := s2[left]
			if need[d] == window[d] {
				valid--
			}
			window[d]--
			left++
		}
	}
	return false
}
