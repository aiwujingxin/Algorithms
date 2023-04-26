package classic

import "fmt"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/27 21:52
 */

func computeSimilarities(docs [][]int) []string {
	n := len(docs)
	if n == 0 {
		return []string(nil)
	}
	dp := make([][][2]int, n) // dp[i][j][0] 交集，dp[i][j][1] 并集
	for i := 0; i < n; i++ {
		dp[i] = make([][2]int, n)
		for j := i + 1; j < n; j++ {
			dp[i][j][1] = len(docs[i]) + len(docs[j])
		}
	}
	visited := make(map[int][]int) // 某个单词已经在哪篇文章出现过
	for i, doc := range docs {
		for _, word := range doc {
			if docIndexes, ok := visited[word]; ok {
				for _, j := range docIndexes {
					dp[j][i][0]++
					dp[j][i][1]--
				}
			}
			visited[word] = append(visited[word], i)
		}
	}
	var res []string
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			sim := float64(dp[i][j][0]) / float64(dp[i][j][1])
			if sim >= 0.0001 {
				res = append(res, fmt.Sprintf("%d,%d: %.4f", i, j, sim+1e-9))
			}
		}
	}
	return res
}
