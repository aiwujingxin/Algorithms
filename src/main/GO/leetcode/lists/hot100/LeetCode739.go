package hot100

func dailyTemperatures(temperatures []int) []int {
	if len(temperatures) == 0 {
		return nil
	}
	stack := make([]int, 0)
	res := make([]int, len(temperatures))
	stack = append(stack, 0)
	for i := 1; i < len(temperatures); i++ {
		for len(stack) > 0 && temperatures[stack[len(stack)-1]] < temperatures[i] {
			pop := stack[len(stack)-1]
			res[pop] = i - pop
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}
	return res
}
