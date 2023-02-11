package topinterview

func wordBreak(s string, wordDict []string) []string {
	trie := newTrie()
	for _, w := range wordDict {
		trie.insert(w)
	}
	list := make([]string, 0)
	var dfs func(s string, sb string, root *Trie, index int)
	dfs = func(s string, sb string, root *Trie, index int) {
		if index == len(s) && root.isEnd {
			list = append(list, sb)
		} else if index < len(s) {
			next := root.children[s[index]-'a']
			if next != nil {
				sb = sb + string(s[index])

				tempSb := sb

				dfs(s, sb, next, index+1)
				if next.isEnd {
					tempSb = tempSb + (" ")
					dfs(s, tempSb, trie, index+1)
				}
			}
		}
	}
	dfs(s, "", trie, 0)
	return list
}
