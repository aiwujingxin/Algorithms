package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/25 12:47
 */

func longestCommonSubsequence(text1 string, text2 string) int {

	if len(text1) == 0 || len(text2) == 0 {
		return 0
	}

	dp := make([][]int, len(text1)+1)
	for i := 0; i < len(text1); i++ {
		dp[i] = make([]int, len(text2)+1)
	}
	for i := 0; i < len(text1); i++ {
		for j := 0; j < len(text2); j++ {
			if text1[i] == text2[j] {
				dp[i+1][j+1] = dp[i][j] + 1
			} else {
				dp[i+1][j+1] = Max(dp[i][j+1], dp[i+1][j])
			}
		}
	}
	return dp[len(dp)-1][len(dp[0])-1]
}
