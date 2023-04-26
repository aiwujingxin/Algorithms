package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/25 20:09
 * https://leetcode.cn/problems/magic-index-lcci/solution/shou-hua-tu-jie-er-fen-cha-zhao-de-bian-chong-xia-/
 */

func findMagicIndex(nums []int) int {
	var find func(start, end int) int
	find = func(lo, hi int) int {
		if lo > hi {
			return -1
		}
		mid := (lo + hi) / 2
		magicIndex := find(lo, mid-1)
		if magicIndex > -1 {
			return magicIndex
		} else if nums[mid] == mid {
			return mid
		} else {
			return find(mid+1, hi)
		}
	}
	return find(0, len(nums)-1)
}
