package classic

import "strconv"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/26 21:02
 * https://leetcode.cn/problems/number-of-2s-in-range-lcci/solution/by-endlesscheng-x4mf/
 */

func numberOf2sInRange(n int) int {
	s := strconv.Itoa(n)
	length := len(s)

	//表示表示构造到从左往右第 i 位，已经出现了  cnt2 个 2
	//dp 数组的含义就变成在不受到约束时的合法方案数，
	//所以要在 !isLimit 成立时才去记忆化。
	dp := make([][]int, length)
	for i := range dp {
		dp[i] = make([]int, length)
		for j := range dp[i] {
			dp[i][j] = -1
		}
	}
	var f func(int, int, bool) int
	f = func(index, cnt2 int, isLimit bool) int {
		if index == length {
			return cnt2
		}
		if !isLimit && dp[index][cnt2] >= 0 {
			return dp[index][cnt2]
		}
		res := 0
		up := 9
		if isLimit {
			up = int(s[index] - '0')
		} else {
			up = 9
		}

		for d := 0; d <= up; d++ { // 枚举要填入的数字 d
			c := cnt2
			if d == 2 {
				c++
			}
			res += f(index+1, c, isLimit && d == up)
		}
		if !isLimit {
			dp[index][cnt2] = res
		}
		return res
	}
	return f(0, 0, true)
}
