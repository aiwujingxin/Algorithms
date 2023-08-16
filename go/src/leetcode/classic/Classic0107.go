package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 17:18
 */

func rotate(matrix [][]int) {
	if len(matrix) == 0 {
		return
	}
	for i := 0; i < len(matrix)/2; i++ {
		matrix[i], matrix[len(matrix)-1-i] = matrix[len(matrix)-1-i], matrix[i]
	}
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < i; j++ {
			matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
		}
	}
}
