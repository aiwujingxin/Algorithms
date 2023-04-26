package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/10 16:53
 */

func longestWord(words []string) string {

	if len(words) == 0 {
		return ""
	}
	res := ""
	trie := newTrie()
	for _, w := range words {
		trie.insert(w)
	}
	for _, w := range words {
		if trie.find(w, false, trie) {
			if len(w) > len(res) || (len(w) == len(res) && w < res) {
				res = w
			}
		}
	}
	return res
}
