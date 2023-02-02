package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 18:59
 */

func convertInteger(A int, B int) int {
	res := 0
	for i := 0; i < 32; i++ {
		res += (A & 1) ^ (B & 1)
		A >>= 1
		B >>= 1
	}
	return res
}
