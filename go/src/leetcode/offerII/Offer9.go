package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/12 16:06
 */

func numSubarrayProductLessThanK(nums []int, k int) int {
	if len(nums) == 0 {
		return 0
	}
	left := 0
	prod := 1
	count := 0
	for right, num := range nums {
		prod *= num
		for ; left <= right && prod >= k; left++ {
			prod /= nums[left]
		}
		//枚举子数组的右端点，然后来找到满足条件的最小左端点。
		//也即当得到满足条件的窗口时，就意味着得到了以 j 作为右端点时满足条件的左端点的最小值。
		//那么此时满足条件的子数组个数当然就等于窗口能所有能作为左端点的位置个数，即j-i+1
		count += right - left + 1
	}
	return count
}
