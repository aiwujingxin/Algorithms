package topinterview

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/26 15:22
 */

type NumMatrix struct {
	matrix    [][]int
	sumMatrix [][]int
}

func ConstructorNumMatrix(matrix [][]int) NumMatrix {
	return calSumMatrix(matrix)
}

func calSumMatrix(matrix [][]int) NumMatrix {
	sumMatrix := make([][]int, 0)
	for i := 0; i < len(matrix); i++ {
		arr := matrix[i]
		sum := make([]int, len(matrix[0]))
		sum[0] = arr[0]
		for j := 1; j < len(arr); j++ {
			sum[j] = sum[j-1] + arr[j]
		}
		sumMatrix = append(sumMatrix, sum)
	}
	for col := 0; col < len(matrix[0]); col++ {
		for row := 1; row < len(matrix); row++ {
			sumMatrix[row][col] += sumMatrix[row-1][col]
		}
	}
	return NumMatrix{
		matrix:    matrix,
		sumMatrix: sumMatrix,
	}
}

func (this *NumMatrix) Update(row int, col int, val int) {
	this.matrix[row][col] = val
	this.matrix = calSumMatrix(this.matrix).matrix
	this.sumMatrix = calSumMatrix(this.matrix).sumMatrix
}

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	var B, C, D = 0, 0, 0
	if row1 != 0 {
		B = this.sumMatrix[row1-1][col2]
	}
	if col1 != 0 {
		C = this.sumMatrix[row2][col1-1]
	}
	if row1 != 0 && col1 != 0 {
		D = this.sumMatrix[row1-1][col1-1]
	}
	return this.sumMatrix[row2][col2] - B - C + D
}
