package classic

import (
	"sort"
)

/**
 * @Author: jingxinwu
 * @Date: 2023/2/27 21:58
 * https://leetcode.cn/problems/word-rectangle-lcci/solution/bfs-trie-by-dongbixibi/
 */

type TrieNode struct {
	next [26]*TrieNode
	end  bool
}

func insert(root *TrieNode, str string) {
	next := root
	for i := range str {
		key := str[i] - 'a'
		if next.next[key] == nil {
			next.next[key] = &TrieNode{}
		}
		next = next.next[key]
	}
	next.end = true
}

/*
*
words.length <= 1000
words[i].length <= 100
*/
func maxRectangle(words []string) []string {
	root := &TrieNode{}
	group := map[int][]int{}
	for i, word := range words {
		insert(root, word)
		group[len(word)] = append(group[len(word)], i)
	}

	lengths := make([]int, len(group))
	{
		i := 0
		for _, v := range group {
			lengths[i] = len(words[v[0]])
			i++
		}
		sort.Slice(lengths, func(i, j int) bool {
			return lengths[i] > lengths[j]
		})
	}

	type pair struct {
		nodes   []*TrieNode
		indexes []int
	}

	resIndexes := []int{}
	s := 0
	//从最大长度开始
	for _, l := range lengths {
		if l*l <= s {
			break
		}
		start := &pair{nodes: make([]*TrieNode, l)}
		for i := 0; i < l; i++ {
			start.nodes[i] = root
		}
		queue := []*pair{start}
		for len(queue) > 0 {
			q := queue[0]
			queue = queue[1:]
			/**
			"this", "real", "hard", "trh", "hea", "iar", "sld"
			*/
			allEnd := true
		nextWord:
			for _, idx := range group[l] {
				word := words[idx]
				var nodes []*TrieNode
				for col := range word {
					node := q.nodes[col].next[word[col]-'a']
					if node == nil {
						continue nextWord
					}
					nodes = append(nodes, node)
					allEnd = allEnd && node.end
				}

				indexes := make([]int, len(q.indexes)+1)
				copy(indexes, q.indexes)
				indexes[len(indexes)-1] = idx
				queue = append(queue, &pair{nodes, indexes})
				if !allEnd {
					continue
				}
				//计算面积
				if _s := (len(q.indexes) + 1) * l; _s > s {
					s = _s
					resIndexes = indexes
				}
			}
		}
	}

	res := make([]string, len(resIndexes))
	for i, idx := range resIndexes {
		res[i] = words[idx]
	}

	return res
}
