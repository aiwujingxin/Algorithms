package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/2 21:55
 */

func merge(A []int, m int, B []int, n int) {
	i := m - 1
	j := n - 1
	index := len(A) - 1
	for i >= 0 && j >= 0 {
		if A[i] <= B[j] {
			A[index] = B[j]
			j--

		} else {
			A[index] = A[i]
			i--
		}
		index--
	}
	for i >= 0 {
		A[index] = A[i]
		i--
		index--
	}
	for j >= 0 {
		A[index] = B[j]
		j--
		index--
	}
}
