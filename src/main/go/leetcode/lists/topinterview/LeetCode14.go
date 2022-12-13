package topinterview

import "math"

func longestCommonPrefix(strs []string) string {

	length := math.MaxInt32
	for i := 0; i < len(strs); i++ {
		length = Min(len(strs[i]), length)
	}
	l := 0
	for i := 0; i < length; i++ {
		ch := strs[0][i]
		match := true
		for j := 1; j < len(strs); j++ {
			if strs[j][i] != ch {
				match = false
				break
			}
		}
		if match {
			l++
		} else {
			break
		}

	}
	return strs[0][:l]
}
