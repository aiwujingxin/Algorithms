package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/22 09:33
 */

func insertBits(N int, M int, i int, j int) int {

	arrN := make([]int, 32)

	for i := 31; i >= 0; i-- {
		arrN[i] = N & 1
		N = N >> 1
	}

	arrM := make([]int, 0)

	for M > 0 {
		arrM = append(arrM, M&1)
		M = M >> 1
	}
	index := 0
	for i := len(arrN) - 1 - i; i > len(arrN)-1-j-1; i-- {
		if index < len(arrM) {
			arrN[i] = arrM[index]
			index++
		} else {
			arrN[i] = 0
		}
	}
	ans := 0
	t := 1
	for i := 31; i >= 0; i-- {
		ans = ans + t*arrN[i]
		t = t * 2
	}
	return ans
}
