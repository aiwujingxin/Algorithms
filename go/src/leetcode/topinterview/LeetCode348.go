package topinterview

type TicTacToe struct {
	rows []int
	cols []int
	n    int
	dia1 int
	dia2 int
}

func ConstructorTicTacToe(n int) TicTacToe {
	return TicTacToe{
		rows: make([]int, n),
		cols: make([]int, n),
		n:    n,
		dia1: 0,
		dia2: 0,
	}
}

func (this *TicTacToe) Move(row int, col int, player int) int {
	cell := 0
	sum := 0
	if player == 1 {
		cell = 1
		sum = this.n
	} else {
		cell = -1
		sum = -this.n
	}
	this.rows[row] += cell
	if this.rows[row] == sum {
		return player
	}
	this.cols[col] += cell
	if this.cols[col] == sum {
		return player
	}

	if row == col {
		this.dia1 += cell
		if sum == this.dia1 {
			return player
		}
	}
	if row+col == this.n-1 {
		this.dia2 += cell
		if sum == this.dia2 {
			return player
		}
	}
	return 0
}
