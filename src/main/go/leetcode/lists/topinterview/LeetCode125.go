package topinterview

import "strings"

func isPalindrome(s string) bool {
	left, right := 0, len(s)-1
	IsAlb := func(ch byte) bool {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')
	}
	for left < right {
		for left < right && (!IsAlb(s[left]) || s[left] == ' ') {
			left++
		}
		for left < right && (!IsAlb(s[right]) || s[right] == ' ') {
			right--
		}
		if strings.ToLower(string(s[left])) == strings.ToLower(string(s[right])) {
			left++
			right--
		} else {
			return false
		}
	}
	return true
}
