package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 15:11
 */

type NumMatrix struct {
	matrix    [][]int
	sumMatrix [][]int
}

func ConstructorNumMatrix(matrix [][]int) NumMatrix {
	sumMatrix := make([][]int, len(matrix))
	for i := 0; i < len(matrix); i++ {
		sumMatrix[i] = make([]int, len(matrix[0]))
	}
	for row := 0; row < len(matrix); row++ {
		sumMatrix[row][0] = matrix[row][0]
		for col := 1; col < len(matrix[0]); col++ {
			sumMatrix[row][col] = sumMatrix[row][col-1] + matrix[row][col]
		}
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

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	var A, B, C, D int
	if row1 == 0 {
		B = 0
	} else {
		B = this.sumMatrix[row1][col2]
	}
	if col1 == 0 {
		C = 0
	} else {
		C = this.sumMatrix[row2][Max(0, col1-1)]
	}
	if row1 == 0 && col1 == 0 {
		A = 0
	} else {
		A = this.sumMatrix[Max(0, row1-1)][Max(0, col1-1)]
	}
	D = this.sumMatrix[row2][col2]
	return D - B - C + A
}
