package topinterview

func solve(board [][]byte) {
	if len(board) == 0 {
		return
	}
	visited := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		visited[i] = make([]bool, len(board[0]))
	}
	exp := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		exp[i] = make([]bool, len(board[0]))
	}
	var dfs func(board [][]byte, i int, j int)
	dfs = func(board [][]byte, i int, j int) {
		if i < 0 || i > len(board)-1 || j < 0 || j > len(board[0])-1 || visited[i][j] {
			return
		}
		if board[i][j] == 'O' {
			exp[i][j] = true
			visited[i][j] = true
			dfs(board, i+1, j)
			dfs(board, i, j+1)
			dfs(board, i-1, j)
			dfs(board, i, j-1)
		}
	}

	var xdfs func(board [][]byte, i int, j int)
	xdfs = func(board [][]byte, i int, j int) {
		if i < 0 || i > len(board)-1 || j < 0 || j > len(board[0])-1 || visited[i][j] {
			return
		}
		if board[i][j] == 'O' && !exp[i][j] {
			board[i][j] = 'X'
		}
		visited[i][j] = true
		xdfs(board, i+1, j)
		xdfs(board, i, j+1)
		xdfs(board, i-1, j)
		xdfs(board, i, j-1)
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == 'O' && (i == 0 || i == len(board)-1 || j == 0 || j == len(board[0])-1) {
				dfs(board, i, j)
			}
		}
	}
	//reset
	for i := 0; i < len(board); i++ {
		visited[i] = make([]bool, len(board[0]))
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == 'X' {
				xdfs(board, i, j)
			}
		}
	}
}
