package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 17:20
 */

func setZeroes(matrix [][]int) {
	if len(matrix) == 0 {
		return
	}
	row := make([]bool, len(matrix))
	col := make([]bool, len(matrix[0]))
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] == 0 {
				row[i] = true
				col[j] = true
			}
		}
	}
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if row[i] || col[j] {
				matrix[i][j] = 0
			}
		}
	}
}
