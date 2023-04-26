package topinterview

func isValidSudoku(board [][]byte) bool {
	if len(board) == 0 {
		return true
	}
	for i := 0; i < 9; i++ {
		mp := make(map[byte]bool)
		for j := 0; j < 9; j++ {
			if board[i][j] == '.' {
				continue
			}
			if _, ok := mp[board[i][j]]; ok {
				return false
			} else {
				mp[board[i][j]] = true
			}
		}
		mp = make(map[byte]bool)
	}
	for j := 0; j < 9; j++ {
		mp := make(map[byte]bool)
		for i := 0; i < 9; i++ {
			if board[i][j] == '.' {
				continue
			}
			if _, ok := mp[board[i][j]]; ok {
				return false
			} else {
				mp[board[i][j]] = true
			}

		}
		mp = make(map[byte]bool)
	}

	//fix box
	for i := 0; i < 9; i += 3 {
		for j := 0; j < 9; j += 3 {
			startRow := i
			startCol := j
			mp := make(map[byte]bool)
			for s_i := startRow; s_i < startRow+3; s_i++ {
				for s_j := startCol; s_j < startCol+3; s_j++ {
					if board[s_i][s_j] == '.' {
						continue
					}
					if _, ok := mp[board[s_i][s_j]]; ok {
						return false
					} else {
						mp[board[s_i][s_j]] = true
					}
				}
			}
			mp = make(map[byte]bool)
		}
	}
	return true
}
