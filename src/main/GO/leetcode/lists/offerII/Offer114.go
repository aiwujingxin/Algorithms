package offerII

import "fmt"

func alienOrder(words []string) string {

	if len(words) == 0 {
		return ""
	}
	// 邻接表
	graph := make(map[byte]map[byte]bool)
	//入度表
	inDegrees := make(map[byte]int)

	// 所有点加入图中
	for _, word := range words {
		for i := range word {
			graph[word[i]] = make(map[byte]bool)
			inDegrees[word[i]] = 0
		}
	}

	// 获取所有的边
	for i := 1; i < len(words); i++ {
		w1, w2 := words[i-1], words[i]
		j := 0
		minLen := Min(len(w1), len(w2))
		for ; j < minLen; j++ {
			if w1[j] != w2[j] {
				if !graph[w1[j]][w2[j]] {
					graph[w1[j]][w2[j]] = true
					inDegrees[w2[j]]++
				}
				break
			}
		}
		// 如果没有找到边，说明较短词语是较长词语的前缀，那么正确的顺序应该是较长的词在后面，否则就是非法输入
		if j == minLen && len(w1) > len(w2) {
			return ""
		}
	}
	fmt.Println(inDegrees)
	fmt.Println(graph)

	var q []uint8
	// 入度为0的点入队，注意要迭代邻接表而非入度表，否则会遗漏孤点
	for u := range graph {
		if k, ok := inDegrees[u]; ok && k == 0 {
			q = append(q, u)
		}
	}
	str := ""
	for len(q) > 0 {
		ch := q[0]
		q = q[1:]
		str += string(ch)

		for next := range graph[ch] {
			inDegrees[next]--
			if inDegrees[next] == 0 {
				q = append(q, next)
			}
		}
	}
	if len(str) == len(graph) {
		return str
	}
	return ""
}
