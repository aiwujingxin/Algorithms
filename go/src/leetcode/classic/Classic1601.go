package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/16 18:39
 */

func swapNumbers(n []int) []int {
	n[0] = n[0] ^ n[1]
	n[1] = n[0] ^ n[1]
	n[0] = n[0] ^ n[1]
	return n
}
