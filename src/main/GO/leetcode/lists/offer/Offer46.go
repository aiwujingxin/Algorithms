package offer

import (
	"strconv"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 23:27
 */

func translateNum(num int) int {
	if num == 0 {
		return 1
	}
	str := strconv.Itoa(num)
	dp := make([]int, len(str))
	if len(str) == 1 {
		return 1
	}
	dp[0] = 1
	if str[:2] >= "10" && str[:2] <= "25" {
		dp[1] = 2
	} else {
		dp[1] = 1
	}
	for i := 2; i < len(str); i++ {
		dp[i] = dp[i-1]
		if str[i-1:i+1] >= "10" && str[i-1:i+1] <= "25" {
			dp[i] += dp[i-2]
		}
	}
	return dp[len(dp)-1]
}
