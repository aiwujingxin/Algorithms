package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/18 14:58
 */

type Trie struct {
	children [26]*Trie
	isEnd    bool
}

/** Initialize your data structure here. */
func ConstructorTrie() Trie {
	return Trie{
		children: [26]*Trie{},
		isEnd:    false,
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	root := this
	for i := 0; i < len(word); i++ {
		if root.children[int(word[i]-'a')] == nil {
			root.children[int(word[i]-'a')] = &Trie{}
		}
		root = root.children[int(word[i]-'a')]
	}
	root.isEnd = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	root := this
	for i := 0; i < len(word); i++ {
		if root.children[int(word[i]-'a')] == nil {
			return false
		}
		root = root.children[int(word[i]-'a')]
	}
	return root.isEnd == true
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	root := this
	for i := 0; i < len(prefix); i++ {
		if root.children[int(prefix[i]-'a')] == nil {
			return false
		}
		root = root.children[int(prefix[i]-'a')]
	}
	return true
}
