package topinterview

import "strconv"

func countAndSay(n int) string {
	if n == 0 {
		return ""
	}
	if n == 1 {
		return "1"
	}
	s := "1"
	for i := 1; i <= n; i++ {
		temp := ""
		ch := s[0]
		count := 0
		index := 0
		for index < len(s) {
			if ch == s[index] {
				index++
				count++
			} else {
				//study
				temp = temp + strconv.Itoa(count) + string(ch)
				ch = s[index]
				count = 1
				index++
			}
		}
		if index == len(s) {
			temp = temp + strconv.Itoa(count) + string(ch)
		}
		s = temp
	}
	return s
}
