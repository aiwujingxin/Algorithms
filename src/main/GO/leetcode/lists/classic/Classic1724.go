package classic

import "math"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/27 21:47
 * https://leetcode.cn/problems/max-submatrix-lcci/solution/zui-da-zi-ju-zhen-da-liang-tu-pian-zhu-s-cc13/
 */

func getMaxMatrix(matrix [][]int) []int {
	m, n := len(matrix), len(matrix[0])
	res := make([]int, 4)

	max := matrix[0][0]

	for beginLine := 0; beginLine < m; beginLine++ {
		sum := make([]int, n)
		for i := beginLine; i < m; i++ {
			begin := 0
			dp := math.MinInt32
			//求连续子数组的最大和
			for j := 0; j < len(sum); j++ {
				sum[j] += matrix[i][j]
				if dp > 0 {
					dp += sum[j]
				} else {
					dp = sum[j]
					begin = j
				}
				if max < dp {
					res[0] = beginLine
					res[1] = begin
					res[2] = i
					res[3] = j
					max = dp
				}

			}
		}
	}
	return res
}
