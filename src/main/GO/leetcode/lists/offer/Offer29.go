package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/29 19:13
 */

func spiralOrder(matrix [][]int) []int {
	if len(matrix) == 0 {
		return []int{}
	}
	rowStart, rowEnd, colStart, colEnd := 0, len(matrix)-1, 0, len(matrix[0])-1
	list := make([]int, 0)
	for rowStart <= rowEnd && colStart <= colEnd {
		for i := colStart; i <= colEnd; i++ {
			list = append(list, matrix[rowStart][i])
		}
		rowStart++

		for i := rowStart; i <= rowEnd; i++ {
			list = append(list, matrix[i][colEnd])
		}
		colEnd--

		if rowStart <= rowEnd && colStart <= colEnd {
			for i := colEnd; i >= colStart; i-- {
				list = append(list, matrix[rowEnd][i])
			}
		}
		rowEnd--
		if rowStart <= rowEnd && colStart <= colEnd {
			for i := rowEnd; i >= rowStart; i-- {
				list = append(list, matrix[i][colStart])
			}

		}
		colStart++
	}
	return list
}
