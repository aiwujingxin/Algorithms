package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 22:32
 */

func add(a int, b int) int {
	for b != 0 {
		carry := (a & b) << 1
		a = a ^ b
		b = carry
	}
	return a
}
