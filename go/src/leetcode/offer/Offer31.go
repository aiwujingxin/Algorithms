package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 23:27
 */

func validateStackSequences(pushed []int, popped []int) bool {
	stack := make([]int, 0)
	for i := 0; i < len(pushed); i++ {
		stack = append(stack, pushed[i])
		for len(popped) > 0 && len(stack) > 0 && stack[len(stack)-1] == popped[0] {
			stack = stack[:len(stack)-1]
			popped = popped[1:]
		}
	}
	return len(popped) == 0
}
