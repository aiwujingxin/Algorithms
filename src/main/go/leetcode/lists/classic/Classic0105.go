package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/6 16:16
 */

func oneEditAway(first string, second string) bool {
	m, n := len(first), len(second)
	if m > n {
		return oneEditAway(second, first)
	}
	if n-m > 1 {
		return false
	}
	i, j, cnt := 0, 0, 0
	for i < len(first) && j < len(second) && cnt <= 1 {
		c1, c2 := first[i], second[j]
		if c1 == c2 {
			i++
			j++
		} else {
			if n == m {
				i++
				j++
				cnt++
			} else {
				j++
				cnt++
			}
		}
	}
	return cnt <= 1
}
