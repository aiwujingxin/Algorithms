package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/31 23:54
 */

func firstUniqChar(s string) byte {
	cnt := [26]int{}
	for _, ch := range s {
		cnt[ch-'a']++
	}
	for i, ch := range s {
		if cnt[ch-'a'] == 1 {
			return s[i]
		}
	}
	return ' '
}
