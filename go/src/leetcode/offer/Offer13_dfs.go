package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/10 17:43
 */

func movingCountDFS(m int, n int, k int) int {
	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}

	return dfs(m, n, 0, 0, k, dp)
}

func dfs(m, n, i, j, k int, dp [][]int) int {
	if i < 0 || j < 0 || i >= m || j >= n || dp[i][j] == 1 ||
		(sumPos(i)+sumPos(j)) > k {
		return 0
	}

	dp[i][j] = 1

	sum := 1
	sum += dfs(m, n, i, j+1, k, dp)
	sum += dfs(m, n, i, j-1, k, dp)
	sum += dfs(m, n, i+1, j, k, dp)
	sum += dfs(m, n, i-1, j, k, dp)
	return sum
}

// 求所有位之和
func sumPos(n int) int {
	var sum int
	for n > 0 {
		sum += n % 10
		n = n / 10
	}
	return sum
}
