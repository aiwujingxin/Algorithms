package hot100

func exist(board [][]byte, word string) bool {
	if len(board) == 0 {
		return true
	}
	visited := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		visited[i] = make([]bool, len(board[0]))
	}
	var dfs func([][]byte, string, int, int, int, [][]bool) bool
	dfs = func(board [][]byte, word string, i int, j int, index int, visited [][]bool) bool {
		if index == len(word) {
			return true
		}
		if i < 0 || i > len(board)-1 || j < 0 || j > len(board[0])-1 ||
			board[i][j] != word[index] || visited[i][j] {
			return false
		}
		visited[i][j] = true
		if dfs(board, word, i+1, j, index+1, visited) ||
			dfs(board, word, i, j+1, index+1, visited) ||
			dfs(board, word, i-1, j, index+1, visited) ||
			dfs(board, word, i, j-1, index+1, visited) {
			return true
		}
		visited[i][j] = false
		return false
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board)-1; j++ {
			if dfs(board, word, i, j, 0, visited) {
				return true
			}
		}
	}
	return false
}
