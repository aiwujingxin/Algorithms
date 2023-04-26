package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/9 22:34
 */

func maxSlidingWindowQ(nums []int, k int) []int {
	var q []int
	n := len(nums)
	ans := make([]int, 0)
	for i := 0; i < n; i++ {
		for len(q) > 0 && nums[i] >= nums[q[len(q)-1]] {
			q = q[:len(q)-1]
		}
		q = append(q, i)
		if q[0] == i-k {
			q = q[1:]
		}
		if i >= k-1 {
			ans = append(ans, nums[q[0]])
		}
	}
	return ans
}
