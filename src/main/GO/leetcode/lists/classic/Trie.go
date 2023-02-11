package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/11 20:50
 */

type Trie struct {
	children [26]*Trie
	isEnd    bool
}

func newTrie() *Trie {
	return &Trie{
		children: [26]*Trie{},
		isEnd:    false,
	}
}

func (t *Trie) insert(s string) {
	node := t
	for i := 0; i < len(s); i++ {
		if node.children[s[i]-'a'] == nil {
			node.children[s[i]-'a'] = newTrie()
		}
		node = node.children[s[i]-'a']
	}
	node.isEnd = true
}

func (t *Trie) rinsert(s string) {
	node := t
	for i := len(s) - 1; i >= 0; i-- {
		if node.children[s[i]-'a'] == nil {
			node.children[s[i]-'a'] = newTrie()
		}
		node = node.children[s[i]-'a']
	}
	node.isEnd = true
}

func (t *Trie) find(s string, flag bool, trie *Trie) bool {
	node := trie
	for i := 0; i < len(s); i++ {
		if node.children[s[i]-'a'] == nil {
			return false
		}
		if node.children[s[i]-'a'].isEnd && t.find(s[i+1:], true, trie) {
			return true
		}
		node = node.children[s[i]-'a']
	}
	return node.isEnd && flag
}
