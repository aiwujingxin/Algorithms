package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 17:00
 */

func findString(words []string, s string) int {
	l, r := 0, len(words)
	for l < r {
		mid := (r-l)/2 + l
		for mid > l && words[mid] == "" {
			mid--
		}
		if words[mid] > s {
			r = mid
		} else if words[mid] < s {
			l = mid + 1
		} else {
			return mid
		}
	}
	return -1
}
