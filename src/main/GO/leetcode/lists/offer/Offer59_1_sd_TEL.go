package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/9 22:02
 */

func maxSlidingWindow(nums []int, k int) []int {
	if len(nums) == 0 {
		return []int{}
	}
	if k > len(nums) {
		return []int{}
	}
	maxWindow := make([]int, len(nums)-k+1)
	maxIndex := 0
	windowIndex := 0
	max := nums[0]
	for i := 1; i < k; i++ {
		if nums[i] > max {
			max = nums[i]
			maxIndex = i
		}
	}
	maxWindow[windowIndex] = max
	windowIndex++

	for i := k; i < len(nums); i++ {
		if max < nums[i] {
			max = nums[i]
			maxIndex = i
		} else if maxIndex <= i-k {
			max = nums[i-k+1]
			maxIndex = i - k + 1
			for j := i - k + 1; j <= i; j++ {
				if max < nums[j] {
					max = nums[j]
					maxIndex = j
				}
			}
		}
		maxWindow[windowIndex] = max
		windowIndex++
	}
	return maxWindow
}
