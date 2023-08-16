package classic

import (
	"math"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/10 16:47
 * https://leetcode.cn/problems/re-space-lcci/solution/jian-dan-dp-trieshu-bi-xu-miao-dong-by-sweetiee/
 */

func respace(dictionary []string, sentence string) int {
	trie := newTrie()
	for i := 0; i < len(dictionary); i++ {
		trie.rinsert(dictionary[i])
	}
	search := func(s string, end int) []int {
		indices := make([]int, 0)
		cur := trie
		for i := end; i >= 0; i-- {
			if cur.children[s[i]-'a'] == nil {
				break
			}
			cur = cur.children[s[i]-'a']
			if cur.isEnd {
				indices = append(indices, i)
			}
		}
		return indices
	}
	dp := make([]int, len(sentence)+1)
	for i := 1; i <= len(sentence); i++ {
		dp[i] = dp[i-1] + 1
		for _, idx := range search(sentence, i-1) {
			dp[i] = Min(dp[i], dp[idx])
		}
	}
	return dp[len(dp)-1]
}

// =====V2
// https://leetcode.cn/problems/re-space-lcci/solution/cong-bao-li-ru-shou-you-hua-yi-ji-triezi-dian-shu-/
func respaceDP(dictionary []string, sentence string) (res int) {
	dp := make([]int, len(sentence)+1)
	for i := 1; i < len(sentence)+1; i++ {
		dp[i] = math.MaxInt
	}
	for i := 0; i < len(sentence); i++ {
		for _, v := range dictionary {
			if i-len(v)+1 >= 0 && sentence[i-len(v)+1:i+1] == v {
				dp[i+1] = Min(dp[i+1], dp[i-len(v)+1])
			}
		}
		dp[i+1] = Min(dp[i+1], dp[i]+1)
	}
	return dp[len(sentence)]
}
