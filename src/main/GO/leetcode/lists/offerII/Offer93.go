package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/28 20:04
 */

func lenLongestFibSubseq(arr []int) int {
	n := len(arr)
	mp := make(map[int]int, n)
	for i, x := range arr {
		mp[x] = i
	}
	dp := make([][]int, n)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	res := 2
	for i := 1; i < len(arr); i++ {
		for j := 0; j < i; j++ {
			// 寻找到前一个状态
			if k, ok := mp[arr[i]-arr[j]]; ok && k < j {
				dp[i][j] = dp[j][k] + 1
			} else {
				dp[i][j] = 2
			}
			res = Max(res, dp[i][j])
		}
	}
	if res > 2 {
		return res
	}
	return 0
}
