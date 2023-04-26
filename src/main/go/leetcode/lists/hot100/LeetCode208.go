package hot100

type Trie struct {
	children [26]*Trie
	isEnd    bool
}

func ConstructorTrie() Trie {
	return Trie{
		children: [26]*Trie{},
		isEnd:    false,
	}
}

func (this *Trie) Insert(word string) {
	cur := this
	for i := range word {
		ch := word[i]
		if cur.children[ch-'a'] == nil {
			cur.children[ch-'a'] = &Trie{}
		}
		cur = cur.children[ch-'a']
	}
	cur.isEnd = true
}

func (this *Trie) Search(word string) bool {
	if len(word) == 0 {
		return true
	}
	curr := this
	for i := 0; i < len(word); i++ {
		ch := word[i]
		if curr.children[ch-'a'] == nil {
			return false
		}
		curr = curr.children[ch-'a']
	}
	return curr.isEnd
}

func (this *Trie) StartsWith(prefix string) bool {
	if len(prefix) == 0 {
		return true
	}
	curr := this
	for i := 0; i < len(prefix); i++ {
		ch := prefix[i]
		if curr.children[ch-'a'] == nil {
			return false
		}
		curr = curr.children[ch-'a']
	}
	return true
}
