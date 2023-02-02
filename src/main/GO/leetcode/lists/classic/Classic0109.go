package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 17:07
 */

func isFlipedString(s1 string, s2 string) bool {

	if len(s1) != len(s2) {
		return false
	}
	if s1 == s2 {
		return true
	}
	for i := 0; i < len(s1); i++ {
		str := s1[i+1:] + s1[:i+1]
		if str == s2 {
			return true
		}
	}
	return false
}
