package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/14 18:15
 * LeetCode371
 */

func add(a, b int) int {
	for b != 0 {
		carry := a & b << 1
		a ^= b
		b = carry
	}
	return a
}
