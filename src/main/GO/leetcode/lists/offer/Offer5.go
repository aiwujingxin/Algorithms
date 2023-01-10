package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 14:55
 */

func replaceSpace(s string) string {
	res := ""
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			res += "%20"
		} else {
			res += string(s[i])
		}
	}
	return res
}
