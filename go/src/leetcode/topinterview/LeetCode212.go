package topinterview

func findWords(board [][]byte, words []string) []string {
	trie := newTrie()
	for i := 0; i < len(words); i++ {
		trie.insert(words[i])
	}
	list := make([]string, 0)
	mp := make(map[string]bool)
	visited := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		visited[i] = make([]bool, len(board[0]))
	}
	var dfs func(root *Trie, str string, i, j int)
	dfs = func(root *Trie, str string, i, j int) {
		if i < 0 || j < 0 || i > len(board)-1 || j > len(board[0])-1 {
			return
		}
		if visited[i][j] {
			return
		}
		str = str + string(board[i][j])
		if !trie.startWith(str) {
			return
		}
		if trie.search(str) {
			mp[str] = true
			//return 不能return
		}
		visited[i][j] = true
		dfs(root, str, i+1, j)
		dfs(root, str, i, j+1)
		dfs(root, str, i-1, j)
		dfs(root, str, i, j-1)
		visited[i][j] = false
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			dfs(trie, "", i, j)
		}
	}
	for k := range mp {
		list = append(list, k)
	}
	return list
}
