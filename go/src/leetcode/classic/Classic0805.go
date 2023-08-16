package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 22:14
 */

func multiply(A int, B int) int {
	n := Min(A, B)
	m := Max(A, B)
	if n == 1 {
		return m
	}
	return m + multiply(n-1, m)
}
