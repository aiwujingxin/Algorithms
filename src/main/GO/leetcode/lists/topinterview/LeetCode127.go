package topinterview

// "ymain"
// "oecij"
// ["ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"]
func ladderLength(beginWord string, endWord string, wordList []string) int {
	q := make([]string, 0)
	q = append(q, beginWord)
	step := 0
	visited := make(map[string]bool)
	wordMp := make(map[string]bool)
	for i := 0; i < len(wordList); i++ {
		wordMp[wordList[i]] = true
	}
	if _, ok := wordMp[endWord]; !ok {
		return 0
	}
	visited[beginWord] = true
	for len(q) > 0 {
		size := len(q)
		for size > 0 {
			cur := q[0]
			q = q[1:]
			if cur == endWord {
				return step
			}
			nexts := getNext(cur, wordMp)
			//fmt.Print(cur)
			//fmt.Println(nexts)
			for _, next := range nexts {
				if visited[next] {
					continue
				}
				q = append(q, next)
				visited[next] = true
			}
			size--
		}
		step++
	}
	return 0
}

func getNext(cur string, wordMp map[string]bool) []string {
	list := make([]string, 0)
	mp := make(map[string]bool)
	for i := 0; i < len(cur); i++ {
		for ch := 'a'; ch <= 'z'; ch++ {
			t := cur[:i] + string(ch) + cur[i+1:]
			if wordMp[t] {
				mp[t] = true
			}
		}
	}
	for k := range mp {
		list = append(list, k)
	}
	return list
}
