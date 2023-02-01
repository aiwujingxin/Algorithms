package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 18:40
 */

func dailyTemperatures(temperatures []int) []int {
	if len(temperatures) == 0 {
		return []int{}
	}
	stack := make([]int, 0)
	stack = append(stack, 0)
	res := make([]int, len(temperatures))
	for i := 1; i < len(temperatures); i++ {
		for len(stack) > 0 && temperatures[stack[len(stack)-1]] < temperatures[i] {
			index := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			res[index] = i - index
		}
		stack = append(stack, i)
	}
	return res
}
