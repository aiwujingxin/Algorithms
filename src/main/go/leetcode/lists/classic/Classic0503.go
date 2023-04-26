package classic

import "fmt"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 21:39
 */

func reverseBits(num int) int {
	arr := [32]int{}
	for i := 31; i >= 0; i-- {
		arr[i] = num & 1
		num >>= 1
	}
	fmt.Println(arr)
	dp := make([][]int, 32)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2)
	}
	if arr[0] == 1 {
		dp[0][0] = 1
		dp[0][1] = 0
	} else {
		dp[0][0] = 0
		dp[0][1] = 1
	}
	max := 0
	for i := 1; i < len(arr); i++ {
		if arr[i] == 1 {
			dp[i][0] = dp[i-1][0] + 1
			dp[i][1] = dp[i-1][1] + 1
		} else if arr[i] == 0 {
			dp[i][0] = 0
			dp[i][1] = dp[i-1][0] + 1
		}
		max = Max(Max(dp[i][0], dp[i][1]), max)
	}
	fmt.Println(dp)
	return max
}
