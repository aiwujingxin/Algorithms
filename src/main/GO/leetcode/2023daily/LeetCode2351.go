package _023daily

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/1 00:54
 */

func repeatedCharacter(s string) byte {
	if len(s) == 0 {
		return ' '
	}
	mp := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		mp[s[i]]++
		if mp[s[i]] == 2 {
			return s[i]
		}
	}
	return ' '
}
