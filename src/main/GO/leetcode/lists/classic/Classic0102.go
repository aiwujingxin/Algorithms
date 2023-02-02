package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 16:52
 */

func CheckPermutation(s1 string, s2 string) bool {
	arr1 := make([]byte, 26)
	arr2 := make([]byte, 26)
	for i := 0; i < len(s1); i++ {
		arr1[s1[i]-'a']++
	}
	for j := 0; j < len(s1); j++ {
		arr2[s2[j]-'a']++
	}

	for i := 0; i < len(arr1); i++ {
		if arr1[i] != arr2[i] {
			return false
		}
	}
	return true
}
