package hot100

func longestPalindrome(s string) string {
	if len(s) == 0 {
		return s
	}
	var res string
	for i := range s {
		a := cal(s, i, i)
		b := cal(s, i, i+1)
		if len(a) > len(res) {
			res = a
		}
		if len(b) > len(res) {
			res = b
		}
	}
	return res
}

func cal(s string, i, j int) string {
	if j > len(s)-1 || s[i] != s[j] {
		return ""
	}
	for (i >= 1) && j < len(s)-1 {
		if s[i-1] == s[j+1] {
			i--
			j++
		} else {
			break
		}
	}
	return s[i : j+1]
}
