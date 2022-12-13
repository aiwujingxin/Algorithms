package topinterview

func strStr(haystack string, needle string) int {
	if len(needle) == 0 {
		return 0
	}
	if len(haystack) == 0 {
		return -1
	}
	next := make([]int, len(needle))
	makeNext(next, needle)
	n, m := len(haystack), len(needle)
	i, j := 0, 0
	for j < n && i < m {
		if haystack[j] == needle[i] {
			i++
			j++
		} else {
			if i-1 >= 0 {
				i = next[i-1]
			} else {
				j++
			}
		}
	}
	if i == m {
		return j - i
	}
	return -1
}

func makeNext(next []int, needle string) {
	i, j := 0, 1
	for j < len(needle) {
		if needle[i] == needle[j] {
			next[j] = i + 1
			i++
			j++
		} else {
			if i-1 >= 0 {
				i = next[i-1]
			} else {
				next[j] = 0
				j++
			}
		}
	}
}
