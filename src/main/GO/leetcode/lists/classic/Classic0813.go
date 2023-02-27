package classic

import "sort"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/26 20:24
 */

func pileBox(box [][]int) int {
	sort.Slice(box, func(i, j int) bool {
		return box[i][0] > box[j][0]
	})
	dp := make([]int, len(box))
	res := 0
	for i := 0; i < len(box); i++ {
		for j := 0; j < i; j++ {
			// i 的三维都要比 j 大
			if box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2] {
				//在 0 <= j < i 范围内找到最大的 dp[j]
				dp[i] = Max(dp[i], dp[j])
			}
		}
		//最后加上最底端箱子的高度
		dp[i] += box[i][2]
		res = Max(dp[i], res)
	}
	return res
}
