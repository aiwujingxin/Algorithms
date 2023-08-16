package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 22:15
 */

func trailingZeroes(n int) (ans int) {
	for n > 0 {
		n /= 5
		ans += n
	}
	return
}
