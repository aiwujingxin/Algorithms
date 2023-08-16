package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/7 21:44
 */

func searchMatrix(matrix [][]int, target int) bool {

	if len(matrix) == 0 {
		return false
	}
	row, col := 0, len(matrix[0])-1

	for row < len(matrix) && col >= 0 {
		if matrix[row][col] == target {
			return true
		}
		if matrix[row][col] < target {
			row++
		} else {
			col--
		}
	}
	return false
}
