package topinterview

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/27 14:18
 */
//https://leetcode.cn/problems/alien-dictionary/solution/kan-cheng-you-ya-de-golangjie-fa-by-deer-8laf/

func alienOrder(words []string) string {
	// 邻接表
	adjacency := make(map[uint8][]uint8)
	//入度表
	inDegrees := make(map[uint8]int)

	// 所有点加入图中
	for _, word := range words {
		for i := range word {
			adjacency[word[i]] = []uint8{}
		}
	}

	// 获取所有的边
	for i := 1; i < len(words); i++ {
		w1, w2 := words[i-1], words[i]
		j := 0
		minLen := Min(len(w1), len(w2))
		for ; j < minLen; j++ {
			if w1[j] != w2[j] {
				adjacency[w1[j]] = append(adjacency[w1[j]], w2[j])
				inDegrees[w2[j]]++
				break
			}
		}

		// 如果没有找到边，说明较短词语是较长词语的前缀，那么正确的顺序应该是较长的词在后面，否则就是非法输入
		if j == minLen && len(w1) > len(w2) {
			return ""
		}
	}

	var q []uint8
	// 入度为0的点入队，注意要迭代邻接表而非入度表，否则会遗漏孤点
	for u := range adjacency {
		if inDegrees[u] == 0 {
			q = append(q, u)
		}
	}

	visited := 0
	for i := 0; i < len(q); i++ {
		cur := q[i]
		for _, adj := range adjacency[cur] {
			inDegrees[adj]--
			if inDegrees[adj] == 0 {
				q = append(q, adj)
			}
		}
		visited++
	}

	// 有环，不存在合法顺序
	if visited != len(adjacency) {
		return ""
	}
	return string(q)
}
