package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 16:50
 */

func isUnique(astr string) bool {

	if len(astr) == 0 {
		return true
	}
	mp := make(map[int32]bool)

	for _, c := range astr {
		if mp[c] {
			return false
		}
		mp[c] = true
	}
	return true
}
