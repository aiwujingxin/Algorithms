package classic

import "strconv"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 17:02
 */

func compressString(s string) string {

	if len(s) == 0 {
		return s
	}
	str := ""
	pre := s[0]
	cur := 0
	for cur < len(s) {
		count := 0
		index := cur
		pre = s[index]

		for index < len(s) && s[index] == pre {
			count++
			index++
		}
		str += string(pre) + strconv.Itoa(count)
		cur = index
	}
	if len(str) >= len(s) {
		return s
	}
	return str
}
