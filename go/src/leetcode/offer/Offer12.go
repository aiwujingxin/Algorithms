package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 21:49
 */

func exist(board [][]byte, word string) bool {

	if len(board) == 0 {
		return false
	}

	visited := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		visited[i] = make([]bool, len(board[0]))
	}

	var dfs func(board [][]byte, word string, index int, i int, j int) bool
	dfs = func(board [][]byte, word string, index int, i int, j int) bool {
		if i < 0 || j < 0 || i >= len(board) || j >= len(board[0]) || visited[i][j] ||
			index >= len(word) || board[i][j] != word[index] {
			return false
		}
		//fix
		if index == len(word)-1 {
			return true
		}
		visited[i][j] = true
		flag := dfs(board, word, index+1, i+1, j) ||
			dfs(board, word, index+1, i, j+1) ||
			dfs(board, word, index+1, i-1, j) ||
			dfs(board, word, index+1, i, j-1)
		visited[i][j] = false
		return flag
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == word[0] {
				res := dfs(board, word, 0, i, j)
				if res {
					return true
				}
			}
		}
	}
	return false
}
