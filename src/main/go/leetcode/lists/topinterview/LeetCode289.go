package topinterview

func gameOfLife(board [][]int) {

	if len(board) == 0 {
		return
	}
	//status 1: live
	//status 2: dead
	//status 3: live-> dead
	//status 4: dead-> live

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			nextStatus(board, i, j)
		}
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == 3 {
				board[i][j] = 0
			}
			if board[i][j] == 4 {
				board[i][j] = 1
			}
		}
	}

	return
}

func nextStatus(board [][]int, i, j int) {
	liveCount, deadCount := 0, 0
	rowStart := Max(i-1, 0)
	rowEnd := Min(i+1, len(board)-1)
	colStart := Max(j-1, 0)
	colEnd := Min(j+1, len(board[0])-1)
	for m := rowStart; m <= rowEnd; m++ {
		for n := colStart; n <= colEnd; n++ {
			if m == i && n == j {
				continue
			}
			if board[m][n] == 1 || board[m][n] == 3 {
				liveCount++
			}
			if board[m][n] == 2 || board[m][n] == 4 {
				deadCount++
			}
		}
	}
	if board[i][j] == 1 {
		if liveCount < 2 || liveCount > 3 {
			board[i][j] = 3
		}
		if liveCount == 2 || liveCount == 3 {
			board[i][j] = 1
		}

	}
	if board[i][j] == 0 {
		if liveCount == 3 {
			board[i][j] = 4
		}
	}
}
