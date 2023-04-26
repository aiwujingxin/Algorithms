package offerII

import "strings"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 16:15
 */

func isAnagram(s string, t string) bool {
	sarr := make([]int, 26)
	tarr := make([]int, 26)
	for i := 0; i < len(s); i++ {
		sarr[int(s[i]-'a')]++
	}
	for i := 0; i < len(t); i++ {
		tarr[int(t[i]-'a')]++
	}
	for i := 0; i < 26; i++ {
		if s[i] != t[i] {
			return false
		}
	}
	if strings.EqualFold(s, t) {
		return false
	}
	return true
}
