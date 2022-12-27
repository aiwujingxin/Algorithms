package topinterview

import "strconv"

func evalRPN(tokens []string) int {

	if len(tokens) == 0 {
		return 0
	}

	stack := make([]string, 0)
	for i := 0; i < len(tokens); i++ {
		token := tokens[i]
		one, tow := stack[len(stack)-1], stack[len(stack)-2]
		stack = stack[:len(stack)-2]
		switch token {
		case "+":
			res := Str2Int(one) + Str2Int(tow)
			stack = append(stack, strconv.Itoa(res))
		case "-":
			res := Str2Int(tow) - Str2Int(one)
			stack = append(stack, strconv.Itoa(res))
		case "*":
			res := Str2Int(one) * Str2Int(tow)
			stack = append(stack, strconv.Itoa(res))
		case "/":
			res := Str2Int(tow) / Str2Int(one)
			stack = append(stack, strconv.Itoa(res))
		default:
			stack = append(stack, token)
		}
	}
	return Str2Int(stack[0])
}
