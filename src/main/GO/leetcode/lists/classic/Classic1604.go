package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/16 21:38
 */

func tictactoe(board []string) string {
	N := len(board)
	XWIN := N * int('X')
	OWIN := N * int('O')
	Pending := 0
	row, col := make([]int, N), make([]int, N)
	l, r := 0, 0

	for i := range board {
		for j := range board[i] {
			row[i] += int(board[i][j])
			col[j] += int(board[i][j])
			if board[i][j] == ' ' {
				Pending++
			}
			if i == j {
				l += int(board[i][j])
			}
			if i == N-j-1 {
				r += int(board[i][j])
			}
		}
	}

	for i := range row {
		if row[i] == XWIN || col[i] == XWIN {
			return "X"
		}
		if row[i] == OWIN || col[i] == OWIN {
			return "O"
		}
	}
	if l == XWIN || r == XWIN {
		return "X"
	}
	if l == OWIN || r == OWIN {
		return "O"
	}
	if Pending > 0 {
		return "Pending"
	}
	return "Draw"
}
