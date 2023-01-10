package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 22:53
 */

func reverseLeftWords(s string, n int) string {
	if len(s) == 0 {
		return s
	}
	n = n % (len(s) - 1)
	data := []byte(s)
	ReverseByte(data, 0, n-1)
	ReverseByte(data, n, len(data)-1)
	ReverseByte(data, 0, len(data)-1)
	return string(data[:])
}

func ReverseByte(s []byte, start, end int) []byte {
	for i, j := start, end; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
	return s
}
