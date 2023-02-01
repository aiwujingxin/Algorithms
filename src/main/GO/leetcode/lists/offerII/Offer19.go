package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/14 15:48
 */

func validPalindrome(s string) bool {
	if len(s) == 0 {
		return true
	}
	if len(s) == 0 {
		return true
	}
	left, right := 0, len(s)-1
	count := 0
	var isValid func(s string, left, right int) bool
	isValid = func(s string, left, right int) bool {
		for left < right {
			if s[left] != s[right] {
				if count == 1 {
					return false
				} else {
					count++
					return isValid(s, left+1, right) || isValid(s, left, right-1)
				}
			} else {
				left++
				right--
			}
		}
		return true
	}
	return isValid(s, left, right)
}
