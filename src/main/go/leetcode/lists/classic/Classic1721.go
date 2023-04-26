package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/15 19:00
 */

func trap(height []int) int {

	if len(height) == 0 {
		return 0
	}
	leftMax := height[0]
	leftArr := make([]int, len(height))
	leftArr[0] = leftMax
	for i := 1; i < len(height); i++ {
		if height[i] > leftMax {
			leftArr[i] = height[i]
			leftMax = height[i]
		} else {
			leftArr[i] = leftMax
		}
	}

	rightMax := height[len(height)-1]
	rightArr := make([]int, len(height))
	rightArr[len(height)-1] = rightMax
	for i := len(height) - 2; i >= 0; i-- {
		if height[i] > rightMax {
			rightArr[i] = height[i]
			rightMax = height[i]
		} else {
			rightArr[i] = rightMax
		}
	}

	res := 0
	for i := 0; i < len(height); i++ {
		res += Min(rightArr[i], leftArr[i]) - height[i]
	}
	return res
}
