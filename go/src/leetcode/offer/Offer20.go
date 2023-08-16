package offer

import "strings"

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 23:40
 */

func isNumber(s string) bool {
	s = strings.TrimSpace(s)
	if len(s) == 0 {
		return false
	}
	if s[0] == '+' || s[0] == '-' {
		s = s[1:]
	}
	strs := strings.Split(s, ".")
	if len(strs) > 2 {
		return false
	}
	if len(strs) == 2 && len(strings.TrimSpace(strs[0])) == 0 && len(strings.TrimSpace(strs[1])) == 0 {
		return false
	}
	hasE := false
	flag := false
	hasNumber := false
	if len(strs) == 1 {
		hasE, hasNumber, flag = isIntegerMust(strs[0], hasNumber)
		if !flag {
			return false
		}
	} else if len(strs) == 2 {
		hasE, hasNumber, flag = isIntegerMust(strs[0], hasNumber)
		if !flag {
			return false
		}
		if hasE {
			return false
		}
		if len(strs[1]) == 0 {
			return true
		}
		hasE, hasNumber, flag = isIntegerMust(strs[1], hasNumber)
		if !flag {
			return false
		}
	}
	return true
}

func isIntegerMust(str string, hasNumber bool) (bool, bool, bool) {
	hasE := false
	index := 0
	for index < len(str) {
		ch := str[index]
		if ch == 'e' || ch == 'E' {
			if hasE {
				return hasE, hasNumber, false
			}
			hasE = true
			if !hasNumber {
				return hasE, hasNumber, false
			}
			return hasE, hasNumber, isIntegerWithSign(str[index+1:])
		} else if ch >= '0' && ch <= '9' {
			hasNumber = true
			index++
		} else {
			return hasE, hasNumber, false
		}
	}
	return hasE, hasNumber, true
}

func isIntegerWithSign(s string) bool {
	index := 0
	if index >= len(s) {
		return false
	}
	if s[index] == '+' || s[index] == '-' {
		return isIntegerWithOutSign(s[index+1:])
	}
	for index < len(s) {
		if s[index] >= '0' && s[index] <= '9' {
			index++
		} else {
			return false
		}
	}
	return true
}

func isIntegerWithOutSign(s string) bool {
	if len(s) == 0 {
		return false
	}
	index := 0
	for index < len(s) {
		if s[index] >= '0' && s[index] <= '9' {
			index++
		} else {
			return false
		}
	}
	return true
}
