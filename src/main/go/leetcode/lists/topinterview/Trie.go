package topinterview

type Trie struct {
	children []*Trie
	isEnd    bool
}

func newTrie() *Trie {
	return &Trie{
		children: make([]*Trie, 26),
		isEnd:    false,
	}
}

func (t *Trie) insert(w string) {
	cur := t
	for i := 0; i < len(w); i++ {
		if cur.children[w[i]-'a'] == nil {
			cur.children[w[i]-'a'] = newTrie()
		}
		cur = cur.children[w[i]-'a']
	}
	cur.isEnd = true
}

func (t *Trie) startWith(str string) bool {
	cur := t
	for i := 0; i < len(str); i++ {
		if cur.children[str[i]-'a'] == nil {
			return false
		}
		cur = cur.children[str[i]-'a']
	}
	return true
}

func (t *Trie) search(str string) bool {
	cur := t
	for i := 0; i < len(str); i++ {
		if cur.children[str[i]-'a'] == nil {
			return false
		}
		cur = cur.children[str[i]-'a']
	}
	return cur.isEnd
}
