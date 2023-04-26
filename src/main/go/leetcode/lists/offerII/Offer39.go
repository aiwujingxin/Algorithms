package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 13:48
 */

func largestRectangleArea(heights []int) int {
	if len(heights) == 0 {
		return 0
	}
	left, right := make([]int, len(heights)), make([]int, len(heights))
	leftStack := make([]int, 0)
	rightStack := make([]int, 0)
	// 最小栈
	for i := 0; i < len(heights); i++ {
		for len(leftStack) > 0 && heights[leftStack[len(leftStack)-1]] >= heights[i] {
			leftStack = leftStack[:len(leftStack)-1]
		}

		if len(leftStack) == 0 {
			left[i] = -1 // 注意边界条件 意味着左边的都比该处大
		} else {
			left[i] = leftStack[len(leftStack)-1]
		}
		leftStack = append(leftStack, i)
	}
	for i := len(heights) - 1; i >= 0; i-- {
		for len(rightStack) > 0 && heights[rightStack[len(rightStack)-1]] >= heights[i] {
			rightStack = rightStack[:len(rightStack)-1]
		}
		if len(rightStack) == 0 {
			right[i] = len(heights) // 注意边界条件 意味着右边的都比该处大
		} else {
			right[i] = rightStack[len(rightStack)-1]
		}
		rightStack = append(rightStack, i)
	}
	res := 0
	for i := 0; i < len(heights); i++ {
		res = Max(res, (right[i]-left[i]-1)*heights[i])
	}
	return res
}
