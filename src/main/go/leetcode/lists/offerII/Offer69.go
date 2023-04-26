package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/19 15:51
 */

//https://leetcode.cn/problems/B1IidL/solution/gong-shui-san-xie-er-fen-san-fen-ji-zhi-lc8zl/

//最小的满足arr[i] > arr[i + 1]的下标
func peakIndexInMountainArray(arr []int) int {
	left, right := 0, len(arr)-1
	for left <= right {
		mid := left + (right-left)/2
		if arr[mid] < arr[mid+1] {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return left
}
