package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 16:55
 */

func replaceSpaces2(S string, length int) string {
	bytes := []byte(S)
	i, j := len(S)-1, length-1
	for j >= 0 {
		if bytes[j] == ' ' {
			bytes[i] = '0'
			bytes[i-1] = '2'
			bytes[i-2] = '%'
			i -= 3
		} else {
			bytes[i] = bytes[j]
			i--
		}
		j--
	}
	return string(bytes[i+1:])
}
