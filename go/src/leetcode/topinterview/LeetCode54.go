package topinterview

func spiralOrder(matrix [][]int) []int {

	if matrix == nil || len(matrix) == 0 {
		return []int{}
	}

	list := make([]int, 0)

	rowStart, rowEnd, colStart, colEnd := 0, len(matrix)-1, 0, len(matrix[0])-1

	for rowStart <= rowEnd && colStart <= colEnd {

		for i := colStart; i <= colEnd; i++ {
			list = append(list, matrix[rowStart][i])
		}
		rowStart++

		for i := rowStart; i <= rowEnd; i++ {
			list = append(list, matrix[i][colEnd])
		}
		colEnd--

		//fix 行没有了 列不能移动
		if rowStart <= rowEnd {
			for i := colEnd; i >= colStart; i-- {
				list = append(list, matrix[rowEnd][i])
			}
		}
		rowEnd--

		if colStart <= colEnd {
			for i := rowEnd; i >= rowStart; i-- {
				list = append(list, matrix[i][colStart])
			}
		}
		colStart++
	}

	return list
}
