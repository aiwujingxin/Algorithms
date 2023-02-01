package offerII

import "strconv"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 19:20
 */

func evalRPN(tokens []string) int {
	if len(tokens) == 0 {
		return 0
	}
	stack := make([]int, 0)
	for i := 0; i < len(tokens); i++ {
		token := tokens[i]
		switch token {
		case "+":
			first, second := stack[len(stack)-1], stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, first+second)
		case "-":
			first, second := stack[len(stack)-1], stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, second-first)
		case "*":
			first, second := stack[len(stack)-1], stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, second*first)
		case "/":
			first, second := stack[len(stack)-1], stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			stack = append(stack, second/first)
		default:
			num, _ := strconv.Atoi(token)
			stack = append(stack, num)
		}
	}
	return stack[0]
}
