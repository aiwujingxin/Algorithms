package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/10 17:24
 */
func findLadders(beginWord string, endWord string, wordList []string) []string {
	flag := map[string]bool{}
	for _, v := range wordList {
		flag[v] = true
	}
	vis := map[string]string{}
	res := make([]string, 0)
	queue := []string{beginWord}

	for len(queue) != 0 {
		size := len(queue)
		for i := 0; i < size; i++ {
			word := queue[0]

			queue = queue[1:]
			if word == endWord {
				res = append([]string{endWord}, res...)
				s := endWord
				for s != beginWord {
					s = vis[s]
					res = append([]string{s}, res...)
				}
				return res
			}
			for k := range word {
				for j := 'a'; j <= 'z'; j++ {
					newWord := word[:k] + string(j) + word[k+1:]
					if flag[newWord] {
						vis[newWord] = word
						queue = append(queue, newWord)
						flag[newWord] = false
					}
				}
			}
		}
	}
	return res
}
