package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 18:16
 */

func findAnagrams(s string, p string) []int {
	if len(s) == 0 {
		return []int{}
	}
	need := make(map[byte]int)
	window := make(map[byte]int)
	valid := 0
	left, right := 0, 0

	for i := 0; i < len(p); i++ {
		need[p[i]]++
	}
	res := make([]int, 0)
	for right < len(s) {
		c := s[right]
		window[c]++
		right++
		if need[c] == window[c] {
			valid++
		}
		for right-left >= len(p) {
			if valid == len(need) {
				res = append(res, left)
			}
			d := s[left]
			if need[d] == window[d] {
				valid--
			}
			window[d]--
			left++
		}
	}
	return res
}
