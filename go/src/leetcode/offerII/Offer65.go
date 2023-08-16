package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/18 18:52
 */

//https://leetcode.com/problems/short-encoding-of-words/solutions/125784/trie-solution/
//后缀字典树
func minimumLengthEncoding(words []string) int {
	type TrieNode struct {
		children map[int]*TrieNode
		depth    int
	}
	root := &TrieNode{
		children: make(map[int]*TrieNode),
		depth:    0,
	}
	leaves := make([]*TrieNode, 0)
	wordSet := make(map[string]bool)
	for i := 0; i < len(words); i++ {
		if wordSet[words[i]] {
			continue
		}
		wordSet[words[i]] = true
	}
	for k := range wordSet {
		word := k
		cur := root
		for j := len(word) - 1; j >= 0; j-- {
			c := word[j]
			if cur.children[int(c-'a')] == nil {
				cur.children[int(c-'a')] = &TrieNode{
					children: make(map[int]*TrieNode),
				}
			}
			cur = cur.children[int(c-'a')]
		}
		cur.depth = len(word) + 1
		leaves = append(leaves, cur)
	}
	res := 0
	for i := 0; i < len(leaves); i++ {
		if len(leaves[i].children) == 0 {
			res += leaves[i].depth
		}
	}
	return res
}

func minimumLengthEncodingV2(words []string) int {
	hashs := make(map[string]struct{})
	for _, word := range words {
		hashs[word] = struct{}{}
	}
	for _, word := range words {
		for i := 1; i < len(word); i++ {
			if _, ok := hashs[word[i:]]; ok {
				delete(hashs, word[i:])
			}
		}
	}
	lens := 0
	for k := range hashs {
		lens += len(k)
		lens += 1
	}
	return lens
}
