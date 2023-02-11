package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/10 17:19
 */

func getValidT9Words(num string, words []string) []string {
	dict := map[byte][]byte{}
	dict['2'] = []byte{'a', 'b', 'c'}
	dict['3'] = []byte{'d', 'e', 'f'}
	dict['4'] = []byte{'g', 'h', 'i'}
	dict['5'] = []byte{'j', 'k', 'l'}
	dict['6'] = []byte{'m', 'n', 'o'}
	dict['7'] = []byte{'p', 'q', 'r', 's'}
	dict['8'] = []byte{'t', 'u', 'v'}
	dict['9'] = []byte{'w', 'x', 'y', 'z'}
	root := newTrie()
	for _, word := range words {
		root.insert(word)
	}
	var ans []string
	var dfs func(index int, t *Trie, word []byte)
	dfs = func(index int, t *Trie, word []byte) {
		if index == len(num) {
			if t.isEnd {
				ans = append(ans, string(word))
			}
			return
		}
		for _, b := range dict[num[index]] {
			next := t.children[b-'a']
			if next == nil {
				continue
			}
			word = append(word, b)
			dfs(index+1, next, word)
			word = word[:len(word)-1]
		}
	}
	dfs(0, root, []byte{})
	return ans
}
