package topinterview

/*
[[1,5,9],
[10,11,13],
[12,13,15]]
8


[[-5,-4],
[-5,-4]]
2

[[1,2],
[1,3]]
3
*/
func kthSmallestMat(matrix [][]int, k int) int {
	if len(matrix) == 0 {
		return 0
	}

	low, high := matrix[0][0], matrix[len(matrix)-1][len(matrix[0])-1]
	for low <= high {
		mid := (low + high) / 2
		count := lessEq(matrix, mid)
		if count < k {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return low
}

func lessEq(matrix [][]int, target int) int {
	count := 0
	row, col := 0, len(matrix[0])-1
	for row <= len(matrix)-1 && col >= 0 {
		if matrix[row][col] <= target {
			row++
			count = count + col + 1
		} else {
			col--
		}
	}
	return count
}
