package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/30 17:19
 */

func ladderLength(beginWord string, endWord string, wordList []string) int {
	if beginWord == endWord {
		return 0
	}
	wordMp := make(map[string]bool)
	for i := 0; i < len(wordList); i++ {
		wordMp[wordList[i]] = true
	}
	if !wordMp[endWord] {
		return 0
	}
	visited := make(map[string]bool)
	q := make([]string, 0)
	q = append(q, beginWord)
	step := 1

	getNexts := func(cur string) []string {
		list := make([]string, 0)
		bytes := []byte(cur)
		for i := 0; i < len(bytes); i++ {
			t := bytes[i]
			for c := 'a'; c <= 'z'; c++ {
				if byte(c) == t {
					continue
				}
				bytes[i] = byte(c)
				if wordMp[string(bytes)] {
					list = append(list, string(bytes))
				}
			}
			bytes[i] = t
		}
		return list
	}

	for len(q) > 0 {
		size := len(q)
		step++
		for size > 0 {
			cur := q[0]
			q = q[1:]
			if cur == endWord {
				return step
			}
			nexts := getNexts(cur)

			for i := 0; i < len(nexts); i++ {
				if nexts[i] == endWord {
					return step
				}
				if visited[nexts[i]] {
					continue
				}
				q = append(q, nexts[i])
				visited[nexts[i]] = true
			}
			size--
		}
	}
	return 0
}
