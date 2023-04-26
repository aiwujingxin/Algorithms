package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 18:46
 */

func isAlienSorted(words []string, order string) bool {
	if len(words) == 0 {
		return true
	}
	mp := make(map[byte]int)
	for i := 0; i < len(order); i++ {
		mp[order[i]] = i
	}
	isSort := func(word1, word2 string) bool {
		if mp[word1[0]] < mp[word2[0]] {
			return true
		}
		index := 0
		for index < Min(len(word1)-1, len(word2)-1) {
			if word1[index] == word2[index] {
				continue
			}
			if mp[word1[index]] < mp[word2[index]] {
				return true
			}
			if mp[word1[index]] > mp[word2[index]] {
				return false
			}
			index++
		}
		return index == len(word1)
	}
	for i := 0; i < len(words)-1; i++ {
		word1 := words[i]
		word2 := words[i+1]
		if !isSort(word1, word2) {
			return false
		}
	}
	return true
}
