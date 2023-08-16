package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/18 15:39
 */

type MagicDictionary struct {
	trie *Trie
}

/** Initialize your data structure here. */
func ConstructorMagicDictionary() MagicDictionary {
	return MagicDictionary{
		trie: &Trie{
			children: [26]*Trie{},
			isEnd:    false,
		},
	}
}

func (this *MagicDictionary) BuildDict(dictionary []string) {
	root := this.trie
	for _, w := range dictionary {
		root.Insert(w)
	}
}

func (this *MagicDictionary) Search(searchWord string) bool {
	root := this.trie
	var dfs func(searchWord string, index int, node *Trie, replaced bool) bool
	dfs = func(searchWord string, index int, node *Trie, replaced bool) bool {
		if index == len(searchWord) {
			return replaced && node.isEnd
		}
		if node.children[int(searchWord[index]-'a')] != nil {
			if dfs(searchWord, index+1, node.children[int(searchWord[index]-'a')], replaced) {
				return true
			}
		}
		if !replaced {
			for i := 0; i < 26; i++ {
				if i != int(searchWord[index]-'a') && node.children[i] != nil {
					if dfs(searchWord, index+1, node.children[i], true) {
						return true
					}
				}
			}
		}
		return false
	}
	return dfs(searchWord, 0, root, false)
}
