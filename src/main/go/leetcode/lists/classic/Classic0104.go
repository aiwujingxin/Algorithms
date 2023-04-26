package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 16:59
 */

func canPermutePalindrome(s string) bool {

	if len(s) == 0 {
		return true
	}
	mp := make(map[byte]int)

	for i := 0; i < len(s); i++ {
		mp[s[i]]++
	}
	oddCount := 0
	for _, v := range mp {

		if v%2 == 1 {
			oddCount++
		}
	}
	return oddCount <= 1
}
