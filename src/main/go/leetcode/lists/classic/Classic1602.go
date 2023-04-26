package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/9 16:36
 */

type WordsFrequency struct {
	dic map[string]int
}

func ConstructorWordsFrequency(book []string) WordsFrequency {
	dic := map[string]int{}
	for _, word := range book {
		dic[word]++
	}
	return WordsFrequency{dic: dic}
}

func (this *WordsFrequency) Get(word string) int {
	return this.dic[word]
}
