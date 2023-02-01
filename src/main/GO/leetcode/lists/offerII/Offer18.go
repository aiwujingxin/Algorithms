package offerII

import "strings"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/14 15:42
 */
func isPalindrome(s string) bool {
	if len(s) == 0 {
		return true
	}
	left, right := 0, len(s)-1
	isA := func(c byte) bool {
		if (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') {
			return true
		}
		return false
	}
	for left < right {
		for left < right && !isA(s[left]) {
			left++
		}
		for left < right && !isA(s[right]) {
			right--
		}
		if strings.ToLower(string(s[left])) != strings.ToLower(string(s[right])) {
			return false
		}
		left++
		right--
	}
	return true
}
